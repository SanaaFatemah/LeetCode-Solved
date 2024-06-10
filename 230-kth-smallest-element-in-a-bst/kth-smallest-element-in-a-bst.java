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
    public int kthSmallest(TreeNode root, int k) {

        int [] counter = new int[]{0};
        int [] kth = new int[]{0};
        helper(root, kth, counter, k);
        return kth[0];
        
    }

    public void helper(TreeNode root, int [] kth,int [] counter, int k )
    {
        if(root == null) return;

        helper(root.left, kth, counter, k);
        counter[0]++;

        if(counter[0] == k)
        {
            kth[0] = root.val;

            return;
        }
        
        helper(root.right, kth, counter, k);
        //return 0;
    }
}