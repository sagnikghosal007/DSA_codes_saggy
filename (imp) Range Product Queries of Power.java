/* Question :- Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.

You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.

Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.

 

Example 1:

Input: n = 15, queries = [[0,1],[2,2],[0,3]]
Output: [2,4,64]
Explanation:
For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be a smaller size.
Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
Answer to 2nd query: powers[2] = 4.
Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64.
Each answer modulo 109 + 7 yields the same answer, so [2,4,64] is returned.
Example 2:

Input: n = 2, queries = [[0,0]]
Output: [2]
Explanation:
For n = 2, powers = [2].
The answer to the only query is powers[0] = 2. The answer modulo 109 + 7 is the same, so [2] is returned.
 */


class Solution {
    public static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        // Extract powers of 2 from n's binary representation
        List<Integer> powers = new ArrayList<>();
        for (int bit = 0; bit < 31; bit++) {
            if (((n >> bit) & 1) == 1) {
                powers.add(1 << bit);
            }
        }

        // Compute prefix products modulo MOD
        int[] prefix = new int[powers.size()];
        prefix[0] = powers.get(0) % MOD;
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = (int) ((1L * prefix[i - 1] * powers.get(i)) % MOD);
        }

        // Answer each query
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = prefix[r];
            } else {
                ans[i] = (int) ((1L * prefix[r] * modInverse(prefix[l - 1], MOD)) % MOD);
            }
        }
        return ans;
    }

    // Modular exponentiation
    private long pow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long x, int mod) {
        return pow(x, mod - 2);
    }
}
