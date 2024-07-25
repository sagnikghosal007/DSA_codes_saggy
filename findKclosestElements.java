//my solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> minHeap=new  PriorityQueue<>();
        for(int num:arr){
            if(k>0){
                minHeap.offer(num);
                k--;
            }
            else if(Math.abs(minHeap.peek()-x)>Math.abs(num-x)){
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll());
        }
        return ans;
    }
}


//code with best time ocmplexity in java
import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = kClosestL(arr, k, x);
        int r = l + k - 1;
        return new MyList(arr, l, r);
    }

    private int kClosestL(int[] arr, int k, int t) {
        int left = 0, right = arr.length - k;
        while (left + 1 < right) {
            int l = left + (right - left) / 2;
            int r = l + k - 1;
            if (arr[r] < t || Math.abs(arr[l] - t) > Math.abs(arr[r] - t)) {
                left = l;
            } else right = l;
        }
        if (Math.abs(arr[left] - t) <= Math.abs(arr[right + k - 1] - t)) {
            return left;
        }
        return right;
    }

    class MyList extends AbstractList<Integer> {
        private int[] arr;
        private int left;
        private int right;

        public MyList(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }

        @Override
        public Integer get(int index) {
            return arr[left + index];
        }

        @Override
        public int size() {
            return right - left + 1;
        }
    }
}
