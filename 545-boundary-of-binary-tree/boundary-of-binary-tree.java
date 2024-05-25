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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList <Integer> ans = new ArrayList<Integer>();

        if (!isLeaf(root))
        ans.add(root.val);
        addLeftBoundary(root, ans);
        addLeaf(root, ans);
        addRightBoundary(root, ans);

        return ans;
        
    }
    public void addLeftBoundary(TreeNode root, ArrayList<Integer> res)
    {
        if(!isLeaf(root))
        {
            TreeNode cur = root.left;
            while(cur!=null)
            {
                if(!isLeaf(cur)) res.add(cur.val);
                if(cur.left!=null) cur = cur.left;
                else
                cur = cur.right;
            }
        }
    }
    public void addRightBoundary(TreeNode root, ArrayList<Integer> res)
    {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        TreeNode cur = root.right;
        while(cur!=null)
        {
            if(!isLeaf(cur)) tmp.add(cur.val);
            if(cur.right!=null) cur  = cur.right;
            else
            cur = cur.left;
        }
        for (int i = tmp.size()-1; i>=0;i--)
        {
            res.add(tmp.get(i));
        }
    }

    public void addLeaf(TreeNode root, ArrayList<Integer> res)
    {
        if(isLeaf(root))
        {
            res.add(root.val);
            return;
        }
        if(root.left!=null) addLeaf(root.left, res);
        if(root.right!=null) addLeaf(root.right, res);


    }


        

    
      

    public boolean isLeaf(TreeNode node)
    {
        if (node.left == null && node.right == null) return true;

        return false;

    }
}