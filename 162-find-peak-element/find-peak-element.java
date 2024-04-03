class Solution {
    //logic of this problem is to simple one half of the array by checking if the number 
    //next to it greater
    public int findPeakElement(int[] num) { 

        int low = 0;
        int high  = num.length-1;

        while (low<=high)
        {
            int mid = low + (high-low)/2;
            //This is an edge case for eg [1,2,3] => inx 2 will be returned. 
            //since 2 < 3 && mid == 3-1 => 2
            //this goes for the other way around as well
            //[5,2,3]
            if ((mid == 0 || num[mid-1]< num[mid]) && (mid == num.length-1 || num[mid+1] < num[mid]))
            return mid;

            //important : what if mid is already on 0 then array index out of bounds will happen. hence we put a check of if mid>0
            //this is to eliminate the sorted part of the array
            //if the previous element is greater than current element, which means the right side of the array is sorted and we skip it
            else if (mid > 0 && num[mid-1] > num[mid])
            {
                high = mid -1;

            }

            else if (mid < num.length && num[mid] < num[mid+1])
            {
                low = mid + 1;
            }
        }   

        return 787;
    
}



}