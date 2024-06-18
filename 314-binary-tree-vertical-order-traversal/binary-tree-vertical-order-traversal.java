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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int max = 0; int min = 0;
        queue.add(root);
        colQ.add(0);

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            int curCol = colQ.poll();

            if(!map.containsKey(curCol))
            {
                map.put(curCol, new ArrayList<>());
            }
            map.get(curCol).add(curr.val);

            if(curr.left!=null)
            {
                queue.add(curr.left);
                colQ.add(curCol-1);
                min = Math.min(min, curCol-1);
            }
            if(curr.right!=null)
            {
                queue.add(curr.right);
                colQ.add(curCol+1);
                max = Math.max(max, curCol+1);
            }
        }
        for(int i=min; i<=max; i++)
        {
            result.add(map.get(i));
        }
        return result;
    }
}