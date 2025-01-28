---------- Using DFS --------
  class Solution {
    int directions[][]={ {0,1},{0,-1}, {1,0},{-1,0} };
    boolean[][] vis;
    public int findMaxFish(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxFishCount=0;
        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                vis=new boolean[m][n];
                maxFishCount=Math.max(maxFishCount, dfs(grid, i, j, m, n));
                }
                
            }
        }

        return maxFishCount;

        
    }
     int dfs(int[][] grid, int i, int j,int m , int n)
    {
        // int m=grid.length;
        // int n=grid[0].length;

        vis[i][j]=true;
        int fishCount=0;


        if(grid[i][j]==0) return fishCount;

        fishCount+=grid[i][j];

        for(int dir[]:directions){
            int di=i+dir[0];
            int dj=j+dir[1];
            if(di>=0 && di<m && dj>=0 && dj<n){
                if(!vis[di][dj]){
                    fishCount+=dfs(grid,di,dj,m,n);
                }
            }
        }

        return fishCount;

    }
}

----------- BFS ------------
  class Solution {
    public int findMaxFish(int[][] grid) {

        int maxFish = 0;
        
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                
                if (grid[i][j] > 0) {
                
                    int fishInRegion = bfs(grid, i, j);
                
                    maxFish = Math.max(maxFish, fishInRegion);
            }
                
            }
        }
        
        return maxFish;
        
    }

    public int bfs(int[][] grid, int i, int j){
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        
        int fish = grid[i][j];

    
        grid[i][j] = 0;
        fish += bfs(grid, i + 1, j);
        fish += bfs(grid, i - 1, j);
        fish += bfs(grid, i, j + 1);
        fish += bfs(grid, i, j - 1);

        
        return fish;
    }
}
