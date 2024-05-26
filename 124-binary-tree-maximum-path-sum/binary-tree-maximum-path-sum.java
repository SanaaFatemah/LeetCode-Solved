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
    public int maxPathSum(TreeNode root) {
        int [] max = new int[1];

        max[0] = Integer.MIN_VALUE;
        findSum(root, max);
        return max[0];
      
    }

    public int findSum(TreeNode root, int [] max)
    {
        if(root == null) return 0;

        int lh = Math.max(0,findSum(root.left, max));
        int rh = Math.max(0,findSum(root.right, max));
        //System.out.println(Math.max(max[0], root.val+lh+rh)+ " " +root.val + " " + lh + " " + rh);
        max[0] = Math.max(max[0], root.val+lh+rh);
        System.out.println(max[0]+ " " +(root.val+lh+rh));
        return root.val + Math.max(lh, rh);
    }
}