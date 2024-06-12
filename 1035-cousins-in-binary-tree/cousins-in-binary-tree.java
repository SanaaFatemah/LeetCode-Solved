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
    int xDepth, yDepth;
    TreeNode xParent, yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);

        return (xDepth == yDepth) && (xParent != yParent);
        
    }

    public void dfs(TreeNode root, int x, int y, int depth, TreeNode parent)
    {
        //base
        if(root == null) return;

        //Logic
        if(x == root.val)
        {
            xDepth = depth;
            xParent = parent;
        }
        else if(y == root.val)
        {
            yDepth = depth;
            yParent = parent;
        }
        dfs(root.left, x, y, depth+1, root);
        dfs(root.right, x, y, depth+1, root);
    }
}