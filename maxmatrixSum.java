class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        long maxSum=0;
        int c=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    c++;//count of nevative nubers in the matrix;
                }
                maxSum+=Math.abs(matrix[i][j]); //absolute sum of the matrix 
                min=Math.min(min,Math.abs(matrix[i][j])); //absolute value of the minimum number
            }
        }
        if(c%2==0)// if count of negative is even 
        return maxSum;
        return maxSum - 2*min; // if count of negative is odd

    }
}
