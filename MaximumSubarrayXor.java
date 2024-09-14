/*You are given an array nums of n integers, and a 2D integer array queries of size q, where queries[i] = [li, ri].

For each query, you must find the maximum XOR score of any 
subarray
 of nums[li..ri].

The XOR score of an array a is found by repeatedly applying the following operations on a so that only one element remains, that is the score:

Simultaneously replace a[i] with a[i] XOR a[i + 1] for all indices i except the last one.
Remove the last element of a.
Return an array answer of size q where answer[i] is the answer to query i.
*/


class Solution {
        public int[] maximumSubarrayXor(int[] A, int[][] queries) {
        int n = A.length, m = queries.length;
        int[][] xor = new int[n][n], score = new int[n][n];
        for (int i = 0; i < n; ++i)
            score[i][i] = xor[i][i] = A[i];
        for (int d = 1; d < n; ++d)
            for (int i = 0, j = d; i < n - d; ++i, ++j)
                score[i][j] = Math.max(Math.max(score[i][j - 1], score[i + 1][j]), xor[i][j] = xor[i][j - 1] ^ xor[i + 1][j]);
        int[] res = new int[m];
        for (int i = 0; i < m; ++i)
            res[i] = score[queries[i][0]][queries[i][1]];
        return res;
    }
}
