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
    public List<Integer> rightSideView(TreeNode root) {
        int level =0;
        List<Integer> res = new ArrayList<Integer>();

        helper(root, level, res);

        return res;

        
    }

    public void helper(TreeNode root, int level, List<Integer> res)
    {
        
        if(root == null) return;

        if(level == res.size())
        {
            res.add(root.val);
        }

        helper(root.right, level+1, res);
        helper(root.left, level+1, res);

    }
}