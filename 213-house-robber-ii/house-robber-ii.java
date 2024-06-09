class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int [] temp1 = new int[n];
        int [] temp2 = new int[n];
        

        if(n==1) return nums[0];

        for(int i=0;i<n;i++)
        {
            if(i!=0) temp1[i] = nums[i];
            if(i!=n-1) temp2[i] = nums[i];
        }
        return Math.max(robAdjacentHouse(temp1), robAdjacentHouse(temp2));

        
    }

    public int robAdjacentHouse(int[] nums)
    {
        int prev = nums[0];
        int prev2 = 0;

        for(int i =1;i<nums.length;i++)
        {
            int take = nums[i];

            if(i>1)
            {
                take = take+prev2;
            }

            int notTake = 0 + prev;

            int curi = Math.max(take, notTake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}