//Aprroach 1 : Brute Force 
//Time Complexity : O(n^4)
//Space Complexity : O(n^2)
class Solution {
    private int n;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        n = grid.length;
        int maxArea = 0;

        // Try changing each '0' to '1' and compute the largest island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1; // Change 0 to 1

                    boolean[][] visited = new boolean[n][n];
                    int largest = 0;

                    // Compute the largest island from scratch
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            if (grid[x][y] == 1 && !visited[x][y]) {
                                largest = Math.max(largest, dfs(grid, x, y, visited));
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, largest);
                    grid[i][j] = 0; // Backtrack
                }
            }
        }

        return (maxArea == 0) ? n * n : maxArea; // If grid was full of 1s
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int count = 1;

        for (int[] dir : directions) {
            count += dfs(grid, i + dir[0], j + dir[1], visited);
        }

        return count;
    }
}


// My aprroach using dfs (unique id use kore korchi ekhane )
//Time complexity: O(m*n)
//Space Complexity : O(m*n)
class Solution {
    private int m, n;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private int DFS(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = id;
        int count = 1;
        
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            count += DFS(grid, x, y, id);
        }
        
        return count;
    }
    
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int islandId = 2;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = DFS(grid, i, j, islandId);
                    maxArea = Math.max(maxArea, size);
                    mp.put(islandId, size);
                    islandId++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0) {
                            set.add(grid[x][y]);
                        }
                    }
                    
                    int sum = 1; // converting current 0 to 1
                    for (int id : set) {
                        sum += mp.get(id);
                    }
                    maxArea = Math.max(maxArea, sum);
                }
            }
        }
        
        return maxArea;
    }
}


//Aprroach 3 : using DSU (Striver's solution)


