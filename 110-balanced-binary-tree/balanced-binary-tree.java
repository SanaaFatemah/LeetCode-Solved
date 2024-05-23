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
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
        //return true;
    }

    public int checkBalance(TreeNode root)
    {
        if(root == null) return 0;

        int lh = checkBalance(root.left);
        System.out.println(root.val + " " + lh);
        int rh = checkBalance(root.right);
        //System.out.println(rh);
        if (lh == -1) return -1;
        if (rh == -1) return -1;
        //System.out.println(Math.abs(lh-rh)+ " " +root.val + " " + lh + " " + rh);
        if(Math.abs(lh-rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}