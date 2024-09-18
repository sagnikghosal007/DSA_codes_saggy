public class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numsAsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsAsInteger, (a, b) -> {
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return (s2 + s1).compareTo(s1 + s2);
        });

        if (numsAsInteger[0] == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int num : numsAsInteger) {
            result.append(num);
        }

        return result.toString();
    }
}

My simpliest code :
class Solution {
    public String largestNumber(int[] nums) {
        String[] array =  new String[nums.length];
        for(int i=0; i<nums.length; i++){
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array,(a,b)-> (b+a).compareTo(a+b));
        if(array[0].equals("0")){
            return "0";
        }
        StringBuilder largest = new StringBuilder();
        for(String arr :array){
            largest.append(arr);
        }
        return largest.toString();
    }
}
