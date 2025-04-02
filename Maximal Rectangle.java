
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] histogram = new int[col];
        int maxArea = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j]++;
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(histogram));
        }
        return maxArea;
    }
    
    private int findMaxArea(int[] h) {
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        Pair<Integer, Integer> p;
        int start, height, max = 0;
        
        for (int i = 0; i < h.length; i++) {
            start = i;
            height = h[i];
            while (!st.isEmpty() && st.peek().getValue() > height) {
                p = st.pop();
                max = Math.max(max, p.getValue() * (i - p.getKey()));
                start = p.getKey();
            }
            st.push(new Pair<>(start, height));
        }
        
        while (!st.isEmpty()) {
            p = st.pop();
            max = Math.max(max, p.getValue() * (h.length - p.getKey()));
        }
        return max;
    }
}
