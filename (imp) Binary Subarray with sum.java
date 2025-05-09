
///prefix sum approach 
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int totalCount = 0;
        int sum = 0;
        int prefixSum[] = new int[nums.length + 1];
        prefixSum[0] = 1;
        
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                totalCount += prefixSum[sum - goal];
            }
            prefixSum[sum]++;
        }
        
        return totalCount; 
    }
}

/*
Note :- The two-pointer (sliding window) technique works well when:

The array has only non-negative numbers.

You're looking for at most or at least a sum (e.g., sum <= k or sum < k).

But in this problem:

You need to count all subarrays that sum to exactly goal, not just one.

nums only contains 0s and 1s (non-negative), but zeros cause overlap of multiple valid subarrays.
*/

class Solution {
    private int solve(int nums[], int goal){
         int count=0;
        int sum=0;
        int i=0;
        int j=0;
        if(goal<0) return 0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>goal){
                sum-=nums[i]; 
                i++;
            }
            //sum <=goal er jonno eta hobe 
            count+=(j-i+1);
            j++;   
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        //this is the main catch of the problem
        //to get sum==gaol we need to this
       return solve(nums,goal) - solve(nums,goal-1);
    }
}



// Same concept applied on Count number of nice subarrays 
// here we will check for odd numbers and if odd then assign them as 1 and evn assign them as 0 
//ultimately we need the sum ==k thats will be my inrtuition 
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
        int n=nums.length;
        int prefixSum[] = new int[n+1];
        prefixSum[0] = 1;
        
        for(int i=0;i<n;i++){
            sum+=isOdd(nums[i]);
            if(sum-k>=0){
                ans+=prefixSum[sum-k];
            }
            prefixSum[sum]++;
        }
        return ans; 
    }
}
