class Solution {
    public void wiggleSort(int[] nums) {
        //Observing a pattern in the final output where the odd indexed numbers were greater than the even indexed numbers.
        //using that observation, we will compare the 2 and initiate a swap if the conditions are satisfied
        for(int i=0; i<nums.length-1;i++)
        {
            if((i%2==0 && nums[i] > nums[i+1]) ||(i%2==1 && nums[i] < nums[i+1]))
            {
                int t = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] =t;
            }
        }
        
    }
}