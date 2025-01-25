//Approach-1 (Brute Force)
//T.C : O(n^3)
//S.C : O(1)
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (true) {
                int smallValue = nums[i];
                int idx = -1;

                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(nums[i] - nums[j]) <= limit) {
                        if (nums[j] < smallValue) {
                            smallValue = nums[j];
                            idx = j;
                        }
                    }
                }

                if (idx != -1) {
                    // Swap the values
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                } else {
                    break;
                }
            }
        }

        return nums;
    }
}

//Approach-2 (using sorting and grouping using unordered_map)
//T.C : ~O(n*logn)
//S.C : ~O(n)
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] vec = nums.clone();
        Arrays.sort(vec);

        int groupNum = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(vec[0], groupNum);
        groupToList.putIfAbsent(groupNum, new LinkedList<>());
        groupToList.get(groupNum).add(vec[0]);

        for (int i = 1; i < n; i++) {
            if (Math.abs(vec[i] - vec[i - 1]) > limit) {
                groupNum++;
            }
            numToGroup.put(vec[i], groupNum);
            groupToList.putIfAbsent(groupNum, new LinkedList<>());
            groupToList.get(groupNum).add(vec[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            result[i] = groupToList.get(group).pollFirst(); // Use and remove the smallest element
        }

        return result;
    }
}

//My Code in java using array of sorted Pairs
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
          int n = nums.length;
        if (n == 0) return new int[0];
        
        // Step 1: Pair each number with its index
        int[][] sortedPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedPairs[i][0] = nums[i];
            sortedPairs[i][1] = i;
        }
        
        // Step 2: Sort by number value
        Arrays.sort(sortedPairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int groupStart = 0;
        
        for (int i = 0; i < n; i++) {
            // Step 3: Check if current group ends here
            if (i == n - 1 || sortedPairs[i+1][0] - sortedPairs[i][0] > limit) {
                // Step 4: Collect and sort original indices
                List<Integer> indices = new ArrayList<>();
                for (int j = groupStart; j <= i; j++) 
                    indices.add(sortedPairs[j][1]);
                Collections.sort(indices);
                
                // Step 5: Assign sorted values to sorted indices
                for (int j = 0; j < indices.size(); j++) 
                    result[indices.get(j)] = sortedPairs[groupStart + j][0];
                
                groupStart = i + 1; // Next group
            }
        }
        return result; 
    }
}
