class Solution {
    public int BFS(int start, Map<Integer, List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>(); // {node, path length}
        queue.add(new int[]{start, 0});
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currNode = current[0];
            int dist = current[1];

            for (int neighbor : adj.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, dist + 1});
                    maxDistance = Math.max(maxDistance, dist + 1);
                }
            }
        }

        return maxDistance;
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Build reversed graph
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = favorite[i];
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int longestCycleEmplCount = 0;
        int happyCoupleEmplCount = 0;

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                //{node, ekhon er node count}
                Map<Integer, Integer> mp = new HashMap<>();
                int currNode = i;
                int currNodeCount = 0;

                while (!vis[currNode]) { // Until cycle is not detected
                    vis[currNode] = true;
                    mp.put(currNode, currNodeCount);

                    int nextNode = favorite[currNode]; // currNode er favourite node amader next node hobe 
                    currNodeCount++;

                    //jodi dekhi it is already visited then we caan say that cycle has been detected 
                    if (mp.containsKey(nextNode)) { // Cycle detected
                        int cycleLength = currNodeCount - mp.get(nextNode); //jekhane visited hobe sekhan kar current node count theke prev node count ta minus korlei amra cycle length ta peye jabo  
                        longestCycleEmplCount = Math.max(longestCycleEmplCount, cycleLength);

                        if (cycleLength == 2) { // Happy couple case
                            boolean[] visitedNodes = new boolean[n];
                            visitedNodes[currNode] = true;
                            visitedNodes[nextNode] = true;
                            happyCoupleEmplCount += 2 + BFS(currNode, adj, visitedNodes) + BFS(nextNode, adj, visitedNodes);
                        }
                        break;
                    }
                    currNode = nextNode;
                }
            }
        }

        return Math.max(happyCoupleEmplCount, longestCycleEmplCount);
    }
}
