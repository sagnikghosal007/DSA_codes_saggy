/*
the denominator is: r * (r-1) * (r-2) ......* 2 * 1.

                                    : 1 * 2 * 3 * ....... * (r-2) * (r-1) * r

i.e. product from i = 1 to i = r.

The numerator is : n * (n-1) * (n-2) * .... * (n-r+1)

                            : (n-r+1) * (n-r+2) * ..... * (n-2) * (n-1) * n

i.e. product of (i + (n-r)) from i = 1 to i = r.

Now since the nCr value could be very large. We need to return the modulo of our answer.

For multiplication: (a * b)%mod = ( (a%mod) * (b%mod) )%mod

For division: (a/b)%mod = ( (a%mod) * (inv(b)%mod) )%mod

                    where, inv(b) i.e. modular mulitplicative inverse of b is                      (b raised to the power (mod-2))%mod which we have                        calulated using binary exponentitaion.

*/

class Solution {

    final int mod = (int)1e9 + 7;

    // Binary exponentiation with modulo
    int binaryExp(int x, int n) {
        if (n == 0) return 1;
        int temp = binaryExp(x, n / 2);
        long tempSq = (1L * temp * temp) % mod;
        if (n % 2 == 0) return (int) tempSq;
        else return (int)((tempSq * x) % mod);
    }

    public int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == n) return 1;

        long ans = 1;

        // Calculate numerator: (n * (n-1) * ... * (n-r+1))
        for (int i = 1; i <= r; i++) {
            ans = (ans * (i + (n - r))) % mod;
        }

        // Calculate denominator and apply modular inverse
        for (int i = 1; i <= r; i++) {
            int inv = binaryExp(i, mod - 2); // Fermat's Little Theorem
            ans = (ans * inv) % mod;
        }

        return (int) ans;
    }
}
