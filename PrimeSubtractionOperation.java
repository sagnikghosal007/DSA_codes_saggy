class Solution {
    // FIND THE PRIME-NUMBERS FORM THE GIVEN NUMBER RANGE[0-n]
    private List<Integer> sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean primeSubOperation(int[] nums) {
        List<Integer> prime = sieveOfEratosthenes(1000);
        for (int i = nums.length; i >= 2; i--) {
            if (nums[i - 2] >= nums[i - 1]) {
                int idx = -1;
                for (int primeIdx = 0; primeIdx < prime.size(); primeIdx++) {
                    if (prime.get(primeIdx) >= nums[i - 2]) {
                        break;
                    }

                    if (nums[i - 2] - prime.get(primeIdx) < nums[i - 1]) {
                        idx = primeIdx;
                        break;
                    }
                }

                if (idx == -1) {
                    return false;
                }
                nums[i - 2] = nums[i - 2] - prime.get(idx);
            }
        }
        return true;
    }
}
