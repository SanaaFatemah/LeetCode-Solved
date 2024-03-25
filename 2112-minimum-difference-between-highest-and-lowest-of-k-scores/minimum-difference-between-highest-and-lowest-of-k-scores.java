class Solution {
    public int minimumDifference(int[] nums, int k) {

        int i=0; int j=k-1;
        // creating a wondow of k numbers and getting the difference between 
        //the lowest and highest amoung the k range of numbers

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        //By sorting the array, we know the least possible difference 
        //will be between the numbers next to each other
        //hence we increment i and j together without a loop
        while(j<nums.length)
        {
            min = Math.min(min, nums[j] -nums[i]);
            i++; j++;
        }

        return min;


        
    }
}