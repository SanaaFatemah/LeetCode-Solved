class Solution {
    public boolean search(int[] nums, int target) {
        int high = nums.length -1;
        int low =0;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(target == nums[mid])
            {
                return true;
            }
            //checking if the right is sorted or the left is unsorted
            if (nums[mid] < nums[high] || nums[mid] < nums[low])
            {
                if (target > nums[mid] && target <= nums[high])
                {
                    low = mid+1;
                }
                else
                high = mid-1;
            }
            else if (nums[mid] > nums[low] || nums[mid] > nums[high])
            {
                if (target < nums[mid] && target >= nums[low])
                {
                    high = mid-1;
                }
                else
                low = mid+1;
            }
            //Since there are dulpicates, this means that nums[mid] == nums[high]==nums[low]
            //we can either move high--, low++, since all 3 are the same
            else
            {
                high--;
            }
        }

        return false;


        
    }
}