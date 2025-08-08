//Qs-> prime path pairs in meeshoLand
// important tree dp + math + up_dp
/* 
Note :-N towns and all the connected by N-1 two-way roads 
The path from town i to town j , includes exactly one town with a prime town number(inclusive of i and j )
count the total number of such prime pairs(i,j) 
*/


/* A tree of N nodes is given to you -> find the numnber of valid paths(i,j) such that in the path from i to j only 1 number has prime number value on it  */


import java.util.*;

public class Solution {
    static final int MAXN = 100005;
    static boolean[] isPrime = new boolean[MAXN];
    static List<Integer>[] tree = new ArrayList[MAXN];
    static boolean[] visited = new boolean[MAXN];
    static long answer = 0;

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAXN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAXN; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // Recursively count the number of white (non-prime) nodes in the subtree of `u`
    static int dfsCountWhite(int u, int p) {
        if (isPrime[u]) return 0;
        int count = 1;
        for (int v : tree[u]) {
            if (v != p) {
                count += dfsCountWhite(v, u);
            }
        }
        return count;
    }

    static void dfs(int u, int p, int upWhite) {
        visited[u] = true;

        if (isPrime[u]) {
            List<Integer> parts = new ArrayList<>();
            int total = upWhite;
            parts.add(upWhite);

            for (int v : tree[u]) {
                if (v != p) {
                    int count = dfsCountWhite(v, u);
                    parts.add(count);
                    total += count;
                }
            }

            long cross = 0;
            for (int part : parts) {
                cross += 1L * part * (total - part);
            }
            cross /= 2;

            answer += cross;
            answer += total;

            for (int v : tree[u]) {
                if (v != p) dfs(v, u, 0);
            }
        } else {
            int currentWhite = dfsCountWhite(u, p);
            for (int v : tree[u]) {
                if (v != p) {
                    int subtreeWhite = dfsCountWhite(v, u);
                    dfs(v, u, upWhite + currentWhite - subtreeWhite);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sieve();

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        Arrays.fill(visited, false);
        dfs(1, 0, 0);

        System.out.println(answer);
    }
}
