class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int num1 = 0,num2 = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= grid.length * grid.length; i++) {
            map.put(i, 0);
        }
        // iterate over each element in grid, if the element is present in map, decrement freq value.
        // at the end, element appearing twice in grid will havr frequency == -1, missing element will have frequency == 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (map.containsKey(grid[i][j])) {
                    // mark it as present by freq - 1
                    map.put(grid[i][j], map.get(grid[i][j]) + 1);
                }
            }
        }
        // iterate over map to get freq 1 = missing number, -1 = appears twice
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            //
            if (val == 0) {
                 num2 = entry.getKey();
            } else if (val >1) {
                 num1 = entry.getKey();
            }
            if (num1 != 0 && num2 != 0) {
                return new int[] { num1, num2 };
            }

        }
        return new int[] {-1,-1};
    }
}

// int num[]=new int[size+1];
//         //repeated element case
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(num[grid[i][j]]==1){
//                     ans[0]=grid[i][j];
//                 }
//                 else{
//                     num[grid[i][j]]++;
//                 }
//             }
//         }
//         //missing element case
//         for(int i=1;i<size+1;i++){
//             if(num[i]==0){
//                 ans[1]=i;
//                 break;
//             }
//         }




//another approach 
// class Solution {
//     public int[] findMissingAndRepeatedValues(int[][] grid) {
//         int n = grid.length;
// 		boolean[] visited = new boolean[n*n+1];
// 		int[] answer = new int[2];
// 		int sum = 0;
// 		for(int row[] : grid) {
// 			for(int val : row) {
// 				if(visited[val])
// 					answer[0] = val;
// 				else {
// 					visited[val] = true;
// 					sum+=val;
// 				}
// 			}
// 		}
		
// 		answer[1] = n*n *(n*n+1)/2 - sum;
		
// 		return answer;
//     }
// }
