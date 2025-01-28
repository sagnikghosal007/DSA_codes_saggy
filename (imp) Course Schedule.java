//Coourse Schedule 1,2,3,4, are of the important problems on graph which are widely or frequently asked in interviews 
--------------------- 207 Course Schedule ---------------
/* 
Approach:
Graph Representation: We can represent the courses and their prerequisites as a directed graph, where each course points to its prerequisites. For example, if course A depends on course B, there will be a directed edge from B to A.
Cycle Detection: A cycle in the graph means that we have a circular dependency (e.g., course A depends on B, B depends on C, and C depends on A), which makes it impossible to complete the courses. We will use Depth-First Search (DFS) to detect cycles. During the DFS:
Visiting: If we encounter a node that is currently in the DFS path (visiting), we know there's a cycle.
Visited: If a node has already been processed (visited), we don't need to process it again.
DFS Traversal: We will traverse each course using DFS. If we encounter a cycle, we immediately return false. Otherwise, if no cycles are detected after checking all courses, return true.
Edge Representation: We will use an adjacency list to store the graph, and for each edge, we will store the course as the source and the prerequisite as the neighbor.
Complexity
Time complexity: O(V+E)
Space complexity: O(V)
*/
class Solution {
    static class Edge{
      //sorce and neighbour 
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      //first e ekta graph representation er adjacency list banabo 
       List<Edge>[] graph=new ArrayList[numCourses];
       for(int i=0;i<numCourses;i++){
        graph[i]=new ArrayList<>();
    }
      for(int preq[]:prerequisites){
        int course=preq[0];
        int prereq=preq[1];
        graph[course].add(new Edge(course,prereq));
      }  


      boolean visited[]=new boolean[numCourses];
      boolean visiting[]=new boolean[numCourses];

      for(int i=0;i< numCourses;i++){
        if(!visited[i]){
            if(hasCycle(graph,visited,visiting,i)){
                return false;
            }
        }
      }
      return true;
    }
    public boolean hasCycle(List<Edge>[] graph,boolean visited[],boolean visiting[],int src){
      //visiting src means return  true
        if(visiting[src])
        {
            return true;

        } 

      //if src is already visited then return false
        if(visited[src]){

            return false;
        }

        visiting[src]=true;

        for(Edge edge : graph[src]){
          //check each edge with neighbour has cycle has cycle or not 
            if(hasCycle(graph, visited,visiting , edge.nbr)){
                return true;
            }
        }

        visited[src] = true;
        visiting[src] = false;

        return false;
    }
}


--------------------- 210 Course Schedule 2 -------------
  // Time Complexity : O(V+E)
  //This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
  class Solution {

    static ArrayList<Integer> graph[];
    static int v;
    static int e;

    static void addEdge(int a, int b){
        graph[b].add(a);
    }


    public int[] findOrder(int num, int[][] pre) {

        v = num;
        e = pre.length;
        graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        
        int indegree[] = new int[v];

        for(int p[]:pre){
            int x=p[0];
            int y=p[1];

            addEdge(x,y);
            indegree[x]++;
        }


        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<v; i++){
            if(indegree[i]==0) q.add(i);
        }

        if(q.size()==0){
            int arr[] = {};
            return arr;
        }
        int ans[] = new int[v];
        int idx = 0;

        while(q.size()!=0){
            int a = q.remove();
            ans[idx++] = a;
            for(var x : graph[a]){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }
        if(idx!=v){
            int arr[] = {};
            return arr;
        }else return ans;

    }
}


---------------------  630 Course Schedule 3   -----------------
/* 
Approach : 
->complete the most amount of jobs by a deadline
->if the total time to complete thsese jobs exceeds the deadline 
->then remove the job that takes the most amount of time

-> make a priority queue or max heap to keep the track of which job takes the most amount of time 
*/
  // TIME COMPLEXITY : O(nlogn)

  class Solution {
    public int scheduleCourse(int[][] courses) {
        //Step 1: we need to sort the courses on basis of the last day (deadline)
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> max_heap=new PriorityQueue<>((a,b)->b-a); 
        //max heap e course jetar duration sob theke beshi front e thakbe 

        int time=0; 
        // Step 2: duration r last day course er store korbo r duration ta time er sathe add korte thakbe 
        for(int[] course:courses){
            int duration=course[0];
            int lastDay=course[1];
            time+=duration; 
            max_heap.offer(duration);
            //eto obdi joto course er time taken ta amader deadline er theke beshi hoye then pop kore debo max heap theke shei course ta ke  
            if(time>lastDay){
                // pop korar por shei course er ja time legechilo total time diye minus kore debo
                time-=max_heap.poll();
            }
        }
        //last e je max heap er size ta pore thakbe seta return korbo tahole max no of jobs ta peuye jabo
        return max_heap.size();
    }
}


--------------------- 1462 Course Schedule 4   ------------

  //using Floyd Warshal Algorithm 
  //logic: mat[s][d]=mat[s][d] || ( mat[s][k] && mat[k][d])

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans =new ArrayList<>();
        boolean[][] isReachable=new boolean[numCourses][numCourses];
        
        for(int preq[]:prerequisites){
            int a=preq[0];
            int b=preq[1];
            isReachable[a][b]=true;
        }

        for(int k=0;k<numCourses;k++){
            for(int s=0;s<numCourses;s++){
                for(int d=0;d<numCourses;d++){
                    isReachable[s][d]=isReachable[s][d] || (isReachable[s][k] && isReachable[k][d]);
                }
            }
        }
         for(int query[]:queries){
             int u=query[0];
             int v=query[1];
             ans.add(isReachable[u][v]);

         }
        return ans;

    }
}


// using Topological Sort (Kahn's Algorithm)
//Approach : Kahn's Algo helps me to traverse the node in a topological sorted manner 
//T.C : O(V^2 + V + E) -> Processing Nodes (each node pushed once in queue) = O(V), Processing edges = O(E), Inserting prerequisites (each node can have ~V prerequisites in worst case): O(V^2)
//S.C : O(V+E)
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create adjacency list and indegree array
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        // Initialize queue with nodes having indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Map from node to set of prerequisite nodes
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                // Add current node and its prerequisites to the neighbor's prerequisites
                prereqMap.computeIfAbsent(neighbor, k -> new HashSet<>()).add(node);
                prereqMap.get(neighbor).addAll(prereqMap.getOrDefault(node, new HashSet<>()));

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Process each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int src = query[0];
            int dest = query[1];
            result.add(prereqMap.getOrDefault(dest, new HashSet<>()).contains(src));
        }

        return result;
    }
}
