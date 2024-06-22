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
    HashMap<Integer, Integer> map;
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();

        dfs(root);

        List<Integer> res = new ArrayList<>();

        for(int key: map.keySet())
        {
            if(map.get(key) == maxCount)
            {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];

        for(int i=0; i<res.size(); i++)
        {
            result[i] = res.get(i);
        }
        return result;
        
    }

    private int dfs(TreeNode root)
    {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int sum = left + right + root.val;

        //if(!map.containsKey(sum))
        {
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        int count = map.get(sum) ;
        maxCount = Math.max(maxCount, count);

        return sum;

    }
}