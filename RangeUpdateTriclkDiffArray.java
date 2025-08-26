import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();      // number of elements
        int k = sc.nextInt();      // allowed variation
        int[] a = new int[n + 1];  // 1-based indexing
        int maxVal = 0;            // to determine the size of nums[]

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            maxVal = Math.max(maxVal, a[i] + k); // max index we need
        }

        // Using array nums as difference array
        int[] nums = new int[maxVal + 2]; // extra space for r+1

        // Build difference array
        for (int i = 1; i <= n; i++) {
            int l = a[i] - k;
            int r = a[i] + k;

            if (l < 0) l = 0; // to avoid negative index

            nums[l] += 1;
            nums[r + 1] -= 1;
        }

        // Prefix sum to get max overlap
        int answer = 0;
        for (int i = 0; i <= maxVal + 1; i++) {
            if (i > 0) nums[i] += nums[i - 1];
            answer = Math.max(answer, nums[i]);
        }

        System.out.println(answer);
    }
}
