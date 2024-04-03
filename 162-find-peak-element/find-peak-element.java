class Solution {
    //logic of this problem is to simple one half of the array by checking if the number 
    //next to it greater
    public int findPeakElement(int[] num) { 

        int low = 0;
        int high  = num.length-1;

        while (low<=high)
        {
            int mid = low + (high-low)/2;

            if ((mid == 0 || num[mid-1]< num[mid]) && (mid == num.length-1 || num[mid+1] < num[mid]))
            return mid;

            //important : what if mid is already on 0 then array index out of bounds will happen. hence we put a check of if mid>0
            else if (mid > 0 && num[mid-1] > num[mid])
            {
                high = mid -1;

            }

            else
            {
                low = mid + 1;
            }
        }   

        return 787;
    
}



}