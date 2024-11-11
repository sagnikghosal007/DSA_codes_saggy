     //VARIATION 1
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

//VARIATION 2
int largestNumber = 0;
        for (int number : numbers) {
            largestNumber = Math.max(largestNumber, number);
        }

        boolean[] primeSieve = new boolean[largestNumber + 1];
        primeSieve[0] = primeSieve[1] = true;
        for (int i = 2; i * i <= largestNumber; i++) {
            if (!primeSieve[i]) {
                for (int j = 2 * i; j <= largestNumber; j += i) {
                    primeSieve[j] = true;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < primeSieve.length; i++) {
            if (!primeSieve[i]) {
                primeNumbers.add(i);
            }
        }

        int index = findMaxSubtraction(primeNumbers, 0, numbers[0]);
        if (index != -1) {
            numbers[0] -= primeNumbers.get(index);
        }

        for (int i = 1; i < numbers.length; i++) {
            index = findMaxSubtraction(primeNumbers, numbers[i - 1], numbers[i]);
            
            if (index == -1 && numbers[i] <= numbers[i - 1]) {
                return false;
            } else if (index != -1) {
                numbers[i] -= primeNumbers.get(index);
            }
        }

        return true;
