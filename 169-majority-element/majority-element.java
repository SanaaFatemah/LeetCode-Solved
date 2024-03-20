class Solution {
    public int majorityElement(int[] nums) {
        int num = 0;;
        int count =0;

        for (int i =0;i<nums.length;i++)
        {
            if(count == 0)
            {
                num = nums[i];
                count++;
            }
            else if (num != nums[i])
            {
                count--;
            }
            else
            {
                count++;
            }
        }
        int count2 =0;
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i] == num)
            {
                count2++;
                if (count2 > (nums.length/2))
                {
                    return num;
                }
            }
        }

        return -1;
        
    }
}