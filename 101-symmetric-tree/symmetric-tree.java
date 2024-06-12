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
 //DFS solution
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag = true;

        dfs(root.left, root.right);
        return flag;
    }

    public void dfs(TreeNode left, TreeNode right)
    {
        //base
        if(left == null && right == null) return;

        if(left == null || right==null ||left.val!=right.val) {
            flag = false;
            return;
        }
        //logic
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}