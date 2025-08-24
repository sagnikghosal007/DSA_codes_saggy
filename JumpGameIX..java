// i to j 
// j > i  -> nums[j] <  nums[i]
// j < i  -> nums[j] >  nums[i]
class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int[] premax=new int[n];
        int[] sufmin=new int[n];
        premax[0]=nums[0];
        for(int i=1;i<n;++i){
            premax[i]=Math.max(premax[i-1],nums[i]);
        }
        sufmin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;--i){
            sufmin[i]=Math.min(sufmin[i+1],nums[i]);
        }
        int start=0;
        int smx=nums[0];
        for(int i=0;i<n-1;++i){
            smx=Math.max(smx,nums[i]);
            if(premax[i]<=sufmin[i+1]){
                for(int idx=start;idx<=i;++idx)
                    ans[idx]=smx;
                start=i+1;
                if(start<n) smx=nums[start];
            }
        }
        for (int idx = start; idx < n; ++idx) {
            ans[idx] = smx;
        }
        return ans;
    }
}
