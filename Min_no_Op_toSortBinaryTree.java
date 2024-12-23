/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Using BFS level order traversal in a binary tree in java
class Solution {
    private void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int countSwaps(int[] values){
        int swaps=0;
        int[] sorted=values.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<values.length;i++){
            mp.put(values[i],i);
        }

        for(int i=0;i<values.length;i++){
            if(values[i]!=sorted[i]){
                swaps++;
                int existingPos=mp.get(sorted[i]);
                mp.put(values[i],existingPos);
                mp.put(sorted[i],i);
                swap(values,existingPos,i);
            }
        }
        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return 0;
        q.offer(root);
        int swaps=0;

        while(!q.isEmpty()){
            int n=q.size();
            int[] values=new int[n];
            for(int i=0;i<n;i++){
                TreeNode curr=q.peek();
                q.poll();
                values[i]=curr.val;

                if(curr.left !=null) q.offer(curr.left);
                if(curr.right !=null) q.offer(curr.right);
            }
            swaps+=countSwaps(values);
        }
        return swaps;
    }
}
