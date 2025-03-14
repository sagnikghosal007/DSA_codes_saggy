Question description:
You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles,
but you cannot merge two piles together.

You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can be allocated candies 
from only one pile of candies and some piles of candies may go unused.

Return the maximum number of candies each child can get.

 

Example 1:

Input: candies = [5,8,6], k = 3
Output: 5
Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1.
We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. 
It can be proven that each child cannot receive more than 5 candies.



1.Brute Force (to builde the intuition we must first write the brute force solution of this question)
Pseudo Code for the brute force approach 

        int n=candies.length;
        int ans =0;
        int sum=0;
        int maxc=0;
        for(int c:candies){
            sum+=c;
            maxc=Math.max(maxc,c);
        }
for(int c=maxc;c>=0;c--){
  long count=0;
for(int i=0;i<n;i++){
  count+=candies[i]/c;
}
if(count>=k){
return c;
}
}
return 0;










2.Optimal approach to solve it using binary search as we are gettinng a intuition of max candies to ther leeast one in a sorted order 
TC:O(logn)

class Solution {
    public boolean canDistribute(int[] candies,int mid, long k){
        int n=candies.length;
        for(int i=0;i<n;i++){
            k-=candies[i]/mid;
            if(k<=0){
                // all childern got mid candies
                return true;
            }
        }
        //all children got mid candies
        return k<=0;
    }
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int ans =0;
        int sum=0;
        int maxc=0;
        for(int c:candies){
            sum+=c;
            maxc=Math.max(maxc,c);
        }
        int l=1;
        int r=maxc;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canDistribute(candies,mid,k)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}
