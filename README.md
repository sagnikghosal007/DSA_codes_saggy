# DSA_codes_saggy
//Function should return true if a deadEnd is found in the bst otherwise return false.
class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return solve(root,1,Integer.MAX_VALUE);
    }
    public static boolean solve(Node root, int min, int max)
    {
        if(root==null)
        return false;
        if(min==max)
        return true;
        boolean left=solve(root.left, min ,root.data-1);
        boolean right=solve(root.right,root.data+1,max);
        return left || right;
    }
}
