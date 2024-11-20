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
class Solution {
    private List<TreeNode> solve(int start, int end,Map<String, List<TreeNode>> ans){
         String key = start + "-" + end;
        List<TreeNode> result= new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> left_bst=solve(start,i-1,ans);
            List<TreeNode> right_bst=solve(i+1,end,ans);
            for(TreeNode L:left_bst){
                for(TreeNode R:right_bst){
                    TreeNode root=new TreeNode(i);
                    root.left=L;
                    root.right=R;
                    result.add(root);
                }
            }
        }
        ans.put(key,result);
        return result;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        Map<String,List<TreeNode>> ans= new HashMap<>();
        return solve(1,n,ans);
        
    }
}
