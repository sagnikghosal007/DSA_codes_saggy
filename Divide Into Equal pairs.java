/* You are given an integer array nums consisting of 2 * n integers.

You need to divide nums into n pairs such that:

Each element belongs to exactly one pair.
The elements present in a pair are equal.
Return true if nums can be divided into n pairs, otherwise return false.
*/
 
//Two pointers approach 
class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int x=n/2;
        int i=0;
        int j=1;
        while(i<nums.length-1 && j<=nums.length-1){
            if(nums[i]==nums[j]){
                    x--;
            }
                i=i+2;
                j=j+2
        }
        return (x==0)?true:false;

    }
}
//HashMap Approach
//  public boolean divideArray(int[] nums) {
//         int n=nums.length;
//         int x=n/2;
//         HashMap<Integer,Integer> mp=new HashMap<>();
//         for(int num:nums){ 
//             mp.put(num,mp.getOrDefault(num,0)+1); 
//         }
//         for(int count:mp.values()){
//              if(count%2!=0){
//                 return false;
//             }
//         }
//         return true;
//     }
