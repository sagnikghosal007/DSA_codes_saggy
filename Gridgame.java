/* 
The first Robot wants to minimize the number of points collected by the second robot. In contrast , the second robot  wants to maximize the number of points it collects. 
If both robots play optimally , return the number of points collected by the second robot 
*/


//Approach - (Using cumulative sum + game strategy)
//T.C : O(col), col = total columns in the grid
//S.C : O(1)

class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long firstRowRemSum=0;
        //extracting the sum of first row only
        for(int i=0;i<n;i++){
            firstRowRemSum+=grid[0][i];
        }
        long secondRowRemSum=0;
        long minimizedRobo2Sum=Long.MAX_VALUE;
        for(int j=0;j<n;j++){
            //robot1 took this strategy
            firstRowRemSum-=grid[0][j];
            //robo2 will try to do best after robo1 taken this strategy
            long bestofRobo2=Math.max(firstRowRemSum,secondRowRemSum);
            minimizedRobo2Sum=Math.min(minimizedRobo2Sum,bestofRobo2);
            //increase the sum of second row
            secondRowRemSum+=grid[1][j];
        }
        return minimizedRobo2Sum;
    }
}
