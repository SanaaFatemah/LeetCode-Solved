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
            if (nums[mid] < nums[high] || nums[mid] < nums[low])
            {
                if (target > nums[mid] && target <= nums[high])
                {
                    low = mid+1;
                }
                else
                high = mid-1;
            }
            else if (nums[mid] > nums[high] || nums[mid] < nums[low])
            {
                if (target < nums[mid] && target >= nums[low])
                {
                    high = mid-1;
                }
                else
                low = mid+1;
            }
            else
            {
                high--;
            }
        }

        return false;


        
    }
}