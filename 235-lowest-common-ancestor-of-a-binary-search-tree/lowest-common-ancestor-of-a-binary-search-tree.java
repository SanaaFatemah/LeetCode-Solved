/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //checking if the values of p and q are lesser than the root so that we can decide on a direction for the traversal
        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        //else if both of them are greater than the root, we will go right
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        //else if eith p or q lie on either side of the node then it means that the LCA will be the main root a tree since everything on right will be greater
        else
        {
            return root;
        }

    }
}