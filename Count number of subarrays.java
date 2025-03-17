//two pointer approach
class Solution {
    private int func(int[] nums,int goal){
        int n=nums.length;
        int l=0;
        int r=0;
        int sum=0;
        int count=0;
        while(r<n){
            sum+=nums[r];
            while(sum>goal){
                //shrinking the sliding window
                sum-=nums[l];
                l++;
            }
            count=count+(r-l+1);
            r++;

        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n =nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0){
                nums[i]=1;
            }
            else{
                nums[i]=0;
            }
        }
        return func(nums,k)-func(nums,k-1);
    }
}

//prefix sum approach 
class Solution {
    private int isOdd(int num){
        if(num%2==1){
            return 1;
        }
        return 0;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int ans= 0;
        int sum = 0;
        int prefixSum[] = new int[nums.length+1];
        prefixSum[0] = 1;
        
        for(int i=0;i<nums.length;i++){
            sum+=isOdd(nums[i]);
            if(sum-k>=0){
                ans+=prefixSum[sum-k];
            }
            prefixSum[sum]++;
        }
        return ans; 
    }
}
