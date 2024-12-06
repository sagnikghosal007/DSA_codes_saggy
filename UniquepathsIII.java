class Solution {
public:
    // row and columb
    int n,m;

    // answer
    int ans = 0;

    // starting and ending position
    int st_x,st_y,en_x,en_y;


    // 4 directional vector
    vector<pair<int,int>>dir = {{1,0},{-1,0},{0,1},{0,-1}};

    // max step possible
    int k;


    // recursive function
    void solve(vector<vector<int>>&grid,vector<vector<bool>>&vis,int i,int j,int curr){
        // base case
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == -1 || vis[i][j] == true) return;

        if(i == en_x and j == en_y){
            if(curr == k) ans++;
            return;
        }

        //mark true
        vis[i][j] = true;

        // iterate on all 4 possible direction
        for(auto it : dir){
            int x = it.first + i;
            int y = it.second + j;
            solve(grid,vis,x,y,curr+1);
        }

        // backtracking
        vis[i][j] = false;
    }

    int uniquePathsIII(vector<vector<int>>& grid) {
        n = grid.size();
        m = grid[0].size();

        // calculate starting , ending and max step possible
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                // staring
                if(grid[i][j] == 1){
                    st_x = i;
                    st_y = j;
                }

                // ending
                else if(grid[i][j] == 2){
                    en_x = i;
                    en_y = j;
                    k++;
                }

                // max step
                else if(grid[i][j] == 0){
                    k++;
                }
            }
        }
        
        // visted vector
        vector<vector<bool>>vis(n,vector<bool>(m,false));
        solve(grid,vis,st_x,st_y,0);
        return ans;
    }
};
