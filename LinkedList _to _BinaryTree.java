/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean check(ListNode head,TreeNode root){
        if(head==null) return true;
        if(root==null) return false;

        if(head.val!= root.val){
            return false;
        }
        return  check(head.next, root.left) || check(head.next,root.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        return check(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }
}
// The most Optimal solution
/*class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, head, root);
    }

    boolean dfs(ListNode head, ListNode cur, TreeNode root) {
        if(cur == null) return true;
        if(root == null) return false;
        if(cur.val == root.val) cur = cur.next;
        else if (head.val == root.val) head = head.next;
        else cur = head;
        return dfs(head, cur, root.left) || dfs(head, cur, root.right);
    }

}*/
