

USING DYNAMIC PROGRAMMING
class Solution {
     long[][] dp;
     private long solve(int[] nums, int i, int time){
         if(i==nums.length) return 0;
         if(dp[i][time]!=-1) return dp[i][time];

         long take=nums[i]*time + solve(nums,i+1,time+1);
         long not_take=solve(nums,i+1,time);
         return dp[i][time]=Math.max(take,not_take);
     }
     public int maxSatisfaction(int[] sati) {
         int n=sati.length;
         Arrays.sort(sati);
         dp=new long[n+1][501];
         for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
         }
         return (int)solve(sati,0,1);
     }
 }

WITHOUT USING DYNAMIC PROGRAMMING

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int prefixSum = 0;      
        int cur = 0;        
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {    
            prefixSum += satisfaction[i];
            
            if(prefixSum<0){
                break;
            }

            cur += prefixSum;           
        }       

        return cur; 
    }
}
