class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        int i = 0, j = 0;
        long ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Find the maximum number in the array
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // Sliding window
        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            
            while (mp.getOrDefault(maxNum, 0) >= k && i <= j) {
                ans += (n - j);
                mp.put(nums[i], mp.get(nums[i]) - 1);
                i++;
            }

            j++;
        }

        return ans;
    }
}


// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//          long maxNum = Long.MIN_VALUE, count = 0;
//         long left = 0, right = 0, ans = 0;
        
//         // Find the maximum element in the array
//         for (int num : nums) {
//             maxNum = Math.max(maxNum, num);
//         }
        
//         while (right < nums.length || left > right) {
//             if (nums[(int)right] == maxNum) {
//                 count++;
//             }
//             // If count is greater than or equal to k, calculate subarrays count
//             while (count >= k) {
//                 if (nums[(int)left] == maxNum) {
//                     count--;
//                 }
//                 left++;
//                 ans += nums.length - right;
//             }
//             right++;
//         }
//         return ans;
//     }
// }
