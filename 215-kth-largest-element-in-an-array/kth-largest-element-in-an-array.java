class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        // Return the kth largest element
        return nums[nums.length - k];
    }
}