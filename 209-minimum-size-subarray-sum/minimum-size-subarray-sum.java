class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        if(nums == null || nums.length ==0) return 0;

        int sum =0; int start =0; int end =0; int minLength = Integer.MAX_VALUE;

        while(end < nums.length)
        {
            sum = sum + nums[end];
            end++;

            while(sum >=target)
            {
                minLength = Math.min(minLength, end-start);

                sum = sum - nums[start];
                start ++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0:minLength;
        
    }

    
}