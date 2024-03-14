class Solution {
    public int[] reverseArray(int start, int end, int [] nums)
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
        return nums;
    }
    public void nextPermutation(int[] nums) {
        int ind =-1;
        int n = nums.length;
        for(int i = n-2; i>=0; i--)
        {
            if (nums[i] < nums[i+1])
            {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            // reverse the whole array:
            
            reverseArray(0, n-1, nums);
            System.out.println(ind);
           
        }
        else
        {
        for (int i = n-1; i > ind; i--)
        {
            System.out.println(i);
            System.out.println(nums[i]);
            if(nums[i] > nums[ind])
            {
                int j = nums[i];
                nums[i] = nums[ind];
                nums[ind] = j;
                break;
            }
        }

        reverseArray(ind+1, n-1, nums);
        }
        

        
        
    }
}