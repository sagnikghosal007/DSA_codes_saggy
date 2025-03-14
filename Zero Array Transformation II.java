
//Difference array +binary search approach 
class Solution {
    private boolean isZeroArray(int[] nums, int[][] queries, int mid) {
        int n = nums.length;
        int[] temp = nums.clone();
        int[] delta = new int[n + 1];

        for (int i = 0; i < mid; i++) {
            int l = queries[i][0], r = queries[i][1], v = queries[i][2];
            delta[l] -= v;
            if (r + 1 < n) delta[r + 1] += v;
        }

        int currDecrement = 0;
        for (int i = 0; i < n; i++) {
            currDecrement += delta[i];
            temp[i] += currDecrement;
            if (temp[i] > 0) return false;
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length, ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isZeroArray(nums, queries, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

//Two pointer approach + Difference array(most optimised solution)
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] diff=new int[n+1];
        int sum=0;
        int qCount=0;
        for(int i=0;i<n;i++){
            while(sum+diff[i]<nums[i]){
                qCount++;
                if(qCount>queries.length) return -1;
                int l=queries[qCount-1][0];
                int r=queries[qCount-1][1];
                int v=queries[qCount-1][2];
                if(r>=i){
                    diff[Math.max(i,l)]+=v;
                    diff[r+1]-=v;
                }
            }
            sum+=diff[i];
        }
        return qCount;
    }
}
