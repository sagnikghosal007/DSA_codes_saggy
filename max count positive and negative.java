//Solution in O(log n)
//optimised solution will do in interview
class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int neg=b_Search(nums,0);
        int pos=n-b_Search(nums,1);
        return (int)Math.max(neg,pos);
    }
    private int b_Search(int nums[] , int target){
        int left=0;
        int right=nums.length-1;
        int ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                ans=mid;
                right=mid-1;
            }
        }
        return ans ;
    }
}

//Solution in O(n)
//brute force 
 class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int pos=0;
        int neg=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0) neg++;
            if(nums[i]>0) pos++;

            maxi=Math.max(maxi,Math.max(neg,pos));

        }
        return maxi;
    }
}
