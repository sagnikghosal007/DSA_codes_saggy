//Problem : 634 : Redundant Connection 
// we need to remove the redundant edge in the graog to make it a tree
//3 approaches 
------------- DSU -----------
//Using DSU (Disjoin Set Union)
class Solution{
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int rank[]=new int[n+1];
        int parent[]=new int[n+1]; 

        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }

        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            int pa=find(a,parent);
            int pb=find(b,parent);
            if(pa==pb){
                return edge;
            }
            union(pa,pb, parent, rank);
        }

        return new int[] {};
    }
    public static void union(int p1,int p2,int[] parent , int[] rank){
        if(p1!=p2){
            if(rank[p1]>rank[p2]){
                parent[p2]=p1;
            }
            else if(rank[p2]>rank[p1]){
                parent[p1]=p2;
            }
            else{
                parent[p2]=p1;
                rank[p1]++;
            }
        }
    }
    public static int find(int x, int[] parent){
        if(parent[x]!=x){
            //check the elemnt is already present on the parent array or not
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
}


-------------More Optimised DSU-----------

 class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
         int n = edges.length;
         int p[] = new int[n+1];
        
         for(int i =  1;i<n+1;i++) p[i] = i;
        
         int ans[] =  {0,0};
        
         for(int i = 0;i<n;i++){
            
             int p1 = p[edges[i][0]];
            int p2 = p[edges[i][1]];
           
             while(p1 != p[p1])
             p1 = p[p1];
            
              while(p2 != p[p2])
             p2 = p[p2];
           
            
             if(p1 == p2){
                 ans[0] = edges[i][0];
                 ans[1] = edges[i][1];
            }
             else{
                 p[p2] = p1;
             }
            
         }
        
         return ans;
        
     }
 }

------------------------------Using DFS---------------
class Solution {
    public int check(int res[],ArrayList<ArrayList<Integer>>adj,int src ,boolean visit[])
    {
        

        visit[src]=true;

        int count=0;
        for(int node:adj.get(src))
        {
            if(visit[node]==false)
            {
                count+=1+check(res,adj,node,visit);
            }
        }
        return count ;

    }
    public int[] findRedundantConnection(int[][] edges) 
    {
        int res[]=new int[2];

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for(int i=0;i<=edges.length;i++)
        adj.add(new ArrayList<>());
        
        for(int e[]:edges)
        {
            int s=e[0];
            int end=e[1];

            adj.get(s).add(end);
            adj.get(end).add(s);
        }


        for(int i=1;i<=edges.length;i++)
        {
            int s=edges[edges.length-i][0];
            int e=edges[edges.length-i][1];
            adj.get(s).remove(Integer.valueOf(e));
            adj.get(e).remove(Integer.valueOf(s));

            boolean visit[]=new boolean[edges.length+1];
            int count=check(res,adj,1,visit);
            if(count ==edges.length-1)
            {
                res[0]=s;
                res[1]=e;
                return res;
            }
            adj.get(s).add(e);
            adj.get(e).add(s);
        }
        return res;
        
    }
}
------------------------------Using BFS (topo Sort ,Kahns algo) ----------------------
// class Solution {
//     public int[] findRedundantConnection(int[][] edges) {
//         HashMap<Integer,List<Integer>> map = new HashMap<>();
//         int max = 0;
//         for(int e[] : edges){
//             map.computeIfAbsent(e[0],k->new ArrayList<>());
//             map.computeIfAbsent(e[1],k->new ArrayList<>());
//             map.get(e[0]).add(e[1]);
//             map.get(e[1]).add(e[0]);
//             max = Math.max(max,Math.max(e[1],e[0]));
//         }
//         int indgree[] = new int[max+1];
//         for(Map.Entry<Integer,List<Integer>> e : map.entrySet()){
//             indgree[e.getKey()] = e.getValue().size();
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0;i<max+1;i++){
//             if(indgree[i]==1){
//                 q.add(i);
//             }
//         }
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0;i<size;i++){
//                 int next = q.poll();
//                 for(int node : map.get(next)){
//                     indgree[node]--;
//                     if(indgree[node]==1)
//                     q.add(node);
//                 }
//             }
//         }
//         for(int i=edges.length-1;i>=0;i--){
//           if(indgree[edges[i][0]]>=2&&indgree[edges[i][1]]>=2)
//           return edges[i];
//         }
//         return edges[0];
//     }
// }
