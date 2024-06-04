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
        int [] kthSmallest = new int[]{0};

        findkthSmallest(root, k, counter, kthSmallest);

        return kthSmallest[0];
        
    }

    public void findkthSmallest(TreeNode root, int k, int [] counter, int [] kthSmallest)
    {
        if(root ==null) return;

        findkthSmallest(root.left, k, counter, kthSmallest);

        counter[0]++;

        if(counter[0] == k)
        {
            kthSmallest[0] = root.val;
            return;
        }
        
        findkthSmallest(root.right, k, counter, kthSmallest);

    }
}