class Solution {
    public int maxDepth(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left);  
        System.out.println("Left" + left);
        
        int right = maxDepth(root.right);
        System.out.println("Right" + left);

        int result = Math.max(left, right) + 1;
        
        // Induction
        return result;
    }
}