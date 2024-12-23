class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s=new HashSet<>();
        int count=0;
        for(int num:nums) s.add(num);
        for(int num:nums){
           if(!s.contains(num-1)){
              int dummy=1;
              int newNum=num+1;
              while(s.contains(newNum)){
                dummy++;
                newNum++;
              }  
              count=Math.max(dummy,count);
           }
        }
        return count;
    }
}
