class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] ans =new Integer[nums.length];
        for(int num: nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }
        Arrays.sort(ans,new Comparator<Integer>(){
            public int compare(Integer a , Integer b){
                if(freq.get(a)!=freq.get(b)){
                    return freq.get(a)-freq.get(b);
                }
                else{
                    return b-a;
                }
            }
        });


        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }

        return nums;
    }
}
