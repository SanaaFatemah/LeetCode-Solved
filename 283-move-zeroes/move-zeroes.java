class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        //Logic behind this is to push every number ahead of the array. 
        //Maintain an index to point where the next number will be inserted while going ahead in the for loop
        //maintain an index to point to the last index in which a number will be there from the beginning to the end. once the all numbers are covered, then while loop to insert zeroes. Do not get boggled when they rearrange. just remember to push all the numbers ahead and add zeroes together at the end.
        for (int i =0; i < nums.length; i++)
        {
            if(nums[i]!=0)
            {
                nums[j] = nums[i];
                j++;
            }
        }
        while(j<nums.length)
        {
            nums[j] = 0;
            j++;
        }
        
    }
}