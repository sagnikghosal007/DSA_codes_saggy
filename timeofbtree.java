/*Approach 1(BFS)
Node Conversion:

The convert function populates an unordered_map named map, representing an adjacency list for each node.
For each node in the binary tree, it creates an entry in the map where the key is the node's value and the value is an unordered_set containing values of its parent, left child, and right child nodes.
Breadth-First Search (BFS):

The amountOfTime function employs a BFS approach to traverse the tree.
It starts by initializing a queue with the start node and a visited set to keep track of visited nodes.
It iterates through the nodes level by level, counting the number of levels or minutes required to visit all reachable nodes from the start node.
During each level traversal, it retrieves adjacent nodes from the map and pushes unvisited nodes into the queue while marking them as visited.
Return Value:

The function returns the count of minutes taken to visit all reachable nodes, subtracting 1 to account for the initial node where the traversal begins.
Complexity
Time complexity:
O(n)

Space complexity:
O(n) */

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer , Set<Integer>> map = new HashMap<>();
        convert(root,0,map);
        Queue <Integer> q = new LinkedList<>();
        q.add(start);
        int time=0;
        Set<Integer> visited= new HashSet<>();
        visited.add(start);
        while(!q.isEmpty())
        {
            int levelSize = q.size();
            while(levelSize>0)
            {
                //poll function returns or removes element from the frosnt basically same as pop function 
                int current=q.poll();
                for(int num : map.get(current))
                {
                    if(!visited.contains(num))
                    {
                        visited.add(num);
                        q.add(num);
                    }
                }
                levelSize--;
            }
            time++;
        }
        return time-1;
    }
    void convert(TreeNode current , int parent , Map<Integer , Set<Integer>> map)
    {
        if (current == null) {
            return;
        } 
        if (!map.containsKey(current.val)) {
            map.put(current.val, new HashSet<>());
        }
        Set<Integer> adjacentList = map.get(current.val);
        if (parent != 0) {
            adjacentList.add(parent);
        } 
        if (current.left != null) {
            adjacentList.add(current.left.val);
        } 
        if (current.right != null) {
            adjacentList.add(current.right.val);
        }
        convert(current.left, current.val, map);
        convert(current.right, current.val, map);
    }
}

