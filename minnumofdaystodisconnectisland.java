class Solution {
    int m, n;
    private int numIslands(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        if(grid==null || grid.length==0)
        {
            return 0;
        }

        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && !vis[i][j])
                {
                    cnt++;
                    dfs(grid,i,j,vis);
                }
            }
        }
        return cnt;
    }
    
    private void dfs(int[][] grid, int i, int j ,boolean[][] vis) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || grid[i][j] == 0) {
            return;
        }

        vis[i][j]=true;
        dfs(grid, i + 1, j,vis); // down
        dfs(grid, i - 1, j,vis); // up
        dfs(grid, i, j + 1,vis); // right
        dfs(grid, i, j - 1,vis); // left
    }
    public int minDays(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int islands=numIslands(grid);

        if(islands>1 || islands==0){
            return 0;
        }
        else{
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1){
                        grid[i][j]=0;//convert it to water
                        islands=numIslands(grid);
                         if(islands>1 || islands==0){
                        return 1;
                        }
                        grid[i][j]=1;//convert again back to lanbds
                    }
                }
            }
        }

        return 2;


    }
}
