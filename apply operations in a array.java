// class Solution {
//     public int[] applyOperations(int[] nums) {
//          for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i + 1]) {
//                 nums[i] *= 2; 
//                 nums[i + 1] = 0; 
//             }
//         }

        
//         int index = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//                 nums[index++] = nums[i]; 
//             }
//         }

        
//         while (index < nums.length) {
//             nums[index++] = 0;
//         }

//         return nums;
//     }
// }


class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        //Arrays.fill(ans,0);
        int k=0;
        int i=0;
        for(i=0;i<n-1;i++){
            if(nums[i]!=0){
                if(nums[i]==nums[i+1]){
                ans[k]=2*nums[i];
                i++;
            }
            else {
                ans[k]=nums[i];
            }
            k++;
            } 
        }
        if(i!=n){
            ans[k]=nums[n-1];
        }
        return ans;
    }
}
