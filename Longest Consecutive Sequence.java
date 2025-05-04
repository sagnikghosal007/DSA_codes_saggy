class Solution {
    public int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        
        Set<Integer> s=new HashSet<>();
        for(int num : nums){
           s.add(num);
        }
        int maxi=0;

        for(int n: s){
            if(!s.contains(n-1)){
                int len=1;
                while(s.contains(len+n)){
                len++;
            }
            maxi=Math.max(len,maxi);
        }
    }
        return maxi;
    }
}
