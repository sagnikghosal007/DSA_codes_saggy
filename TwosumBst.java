class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return traverse(root, root, k);
    }

    private boolean traverse(TreeNode root, TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        int required = k - node.val;
        return search(root, node, required)
            || traverse(root, node.left, k)
            || traverse(root, node.right, k);
    }

    private boolean search(TreeNode node, TreeNode ignoreNode, int val) {
        if (node == null) {
            return false;
        }
        if (node != ignoreNode && node.val == val) {
            return true;
        }
        return val > node.val ? search(node.right, ignoreNode, val) : search(node.left, ignoreNode, val);
    }
}
