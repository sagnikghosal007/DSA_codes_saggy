class Solution {
   private int solve(String s,int i,int j, int rem, int[][][] dp){
        int ans = 0;
        int diff = Math.abs(s.charAt(i) - s.charAt(j));
        int cost = Math.min(diff, 26 - diff);
        if (i > j) {
            return 0;
        }
        if (i == j) { 
            return 1;
        }
        if (dp[i][j][rem] != -1) {
            return dp[i][j][rem];
        }
        ans = Math.max(ans, solve(s, i + 1, j, rem, dp));
        ans = Math.max(ans, solve(s, i, j - 1, rem, dp));
        if (rem >= cost) {
            ans = Math.max(ans, 2 + solve(s, i + 1, j - 1, rem - cost, dp));
        }
        dp[i][j][rem] = ans;
        return ans;
   }
    public int longestPalindromicSubsequence(String s, int k) {
        int[][][] dp = new int[s.length()][s.length()][k + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                for (int r = 0; r <= k; r++) {
                    dp[i][j][r] = -1;
                }
            }
        }
        int result = solve( s,0, s.length() - 1, k, dp);
        return result;
        
    }
}
