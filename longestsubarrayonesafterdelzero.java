class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int maxi=0;
        int zeroCount=0;
        while(j<n){
            if(nums[j]==0) zeroCount++;
            while(zeroCount>1){
                if(nums[i]==0) zeroCount--;
                i++;
            }
            maxi=Math.max(j-i,maxi);
            j++;
        }
        return maxi;
    }
}
