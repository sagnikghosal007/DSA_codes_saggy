// to find the maximum absolute sum of a subarray 
// we will use two approaches here


--------------Approach 1 : using max min sbarray using KADANES ALGO----------
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        int minsum=0;
        int maxsum=0;
        for(int i=0;i<n;i++){
            maxsum+=nums[i];
            minsum+=nums[i];
            if(maxsum>maxi) maxi=maxsum;
            if(minsum<mini) mini=minsum;
            if(maxsum<0) maxsum=0;
            if(minsum>0) minsum=0;
        }
        return Math.max(maxi,Math.abs(mini));
    }
}


----------------Approach 2 : using Prefix Sum (diff between max and min prefixSum )---------------
  class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int PrefixSum=0;
        int maxPrefixSum=0;
        int minPrefixSum=0;
        for(int num:nums){
            PrefixSum+=num;
            maxPrefixSum=Math.max(maxPrefixSum,PrefixSum);
            minPrefixSum=Math.min(minPrefixSum,PrefixSum);
        }
        return maxPrefixSum-minPrefixSum;
    }
}
