class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int preSum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            preSum+=nums[i];
            int rem=preSum-k;
            if(mp.containsKey(rem)){
                count+=mp.get(rem);
            }   
            mp.put(preSum,mp.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}


// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
//         int count=0;
//         int sum=0;
//         map.put(0,1);
//         for(int i=0;i<nums.length;i++)
//         {
//             sum+=nums[i];
//             if(map.containsKey(sum-k))
//             {
//                  count+= map.get(sum-k);
//             }
//             if(map.containsKey(sum))
//             {
//                 map.put(sum,map.get(sum)+1);
//             }
//             else
//             {
//                 map.put(sum,1);
//             }
//         }
//         return count;
//     }
// }
