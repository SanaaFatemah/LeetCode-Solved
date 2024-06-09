class Solution {
    public int rob(int[] nums) {

        int n = nums.length-1;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n, nums, dp);
        
    }

    public int f(int ind, int[] nums, int[] dp)
    {
        if(ind == 0)return nums[ind];
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];
        int pick = nums[ind] + f(ind-2, nums, dp);
        int notPick = 0 + f(ind-1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);

    }

}