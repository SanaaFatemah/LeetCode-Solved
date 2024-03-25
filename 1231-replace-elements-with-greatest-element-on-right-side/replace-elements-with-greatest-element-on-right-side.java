class Solution {
    public int[] replaceElements(int[] arr) {

        int max = -1;
        int tmp =0;


        for (int i= arr.length -1; i>=0 ; i--)
        {
            //assigning the current element with the max on hand.
            tmp =arr[i];
            arr[i] = max;

            //checking for the max here for the element to its left
            if (tmp > max)
            {
                max =tmp;
            }
        }
        return arr;
        
    }
}