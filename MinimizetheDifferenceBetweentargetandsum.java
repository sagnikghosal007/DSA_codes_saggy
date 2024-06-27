class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> possibleSums=new HashSet<>();
        possibleSums.add(0);

        for(int[] row:mat){
            Set<Integer> newSum=new HashSet<>();
            for(int sumSoFar: possibleSums){
                for(int elem :row){
                    newSum.add(sumSoFar + elem);
                }
            }
            possibleSums=newSum;
        }
        int mindiff=Integer.MAX_VALUE;
        for(int sum:possibleSums){
            mindiff=Math.min(mindiff,Math.abs(target-sum));
        }
        return mindiff;

    }
}
