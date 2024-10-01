public int countPalindromes(String s) {
    int mod = 1000_000_007, n = s.length(), ans = 0, cnts[] = new int[10],
    pre[][][] = new int[n][10][10], suf[][][] = new int[n][10][10];
    for (int i = 0; i < n; i++) {
        int c = s.charAt(i) - '0';
        if (i > 0)
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++) {
                    pre[i][j][k] = pre[i - 1][j][k];
                    if (k == c) pre[i][j][k] += cnts[j];
                }
        cnts[c]++;
    }
    Arrays.fill(cnts, 0);
    for (int i = n - 1; i >= 0; i--) {
        int c = s.charAt(i) - '0';
        if (i < n - 1)
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++) {
                    suf[i][j][k] = suf[i + 1][j][k];
                    if (k == c) suf[i][j][k] += cnts[j];
                }
        cnts[c]++;
    }
    for (int i = 2; i < n - 2; i++)
        for (int j = 0; j < 10; j++)
            for (int k = 0; k < 10; k++)
                ans = (int)((ans + 1L * pre[i - 1][j][k] * suf[i + 1][j][k]) % mod);
    return ans;
}
