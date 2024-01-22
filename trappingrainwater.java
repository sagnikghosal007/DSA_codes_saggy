public class trappingrainwater {
    public static int trappedwater(int arr[]) {
        int n = arr.length;
        int water_level;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            water_level = Math.min(leftMax[i], rightMax[i]);
            trappedWater += water_level - arr[i];
        }
        return trappedWater;
    }

    public static void main(String args[]) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedwater(height));
    }

}
