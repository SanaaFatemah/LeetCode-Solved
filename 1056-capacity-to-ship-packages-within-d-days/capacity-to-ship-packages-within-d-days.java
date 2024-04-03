class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int daysNeeded = 0; int currWeight = 0; int totalWeight = 0;
        int maxWeight = 0;
        //setting the left and right to the highest weight and the total weight
        for (int weight : weights)
        {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int left = maxWeight; int right = totalWeight;

        while(left<right)
        {
            //we assume mid to be ships capacity
            int mid = (left + right) / 2;
            daysNeeded = 1; currWeight = 0;
            for ( int weight: weights)
            {
                //if the weight exceeds the particular ships capacity, 
                //we will increment the day and set the currweight to 0 
                //because for the new day we need to start a new weight counter
                if(currWeight + weight > mid)
                {
                    daysNeeded ++;
                    currWeight = 0;
                }
                //By default setting the new days weight to the weight that made the previous days weight overflow
                currWeight += weight;
            }
            //if the number of daysneeded exceeds the days,
            // meaning the current ships capacity(mid) is too less, to increase it we will move it towards the higher weight range
            if(daysNeeded > days)
            {
                left = mid+1;
            }
            //if the daysneeded is lesser than the days gives then the capacity is too much and we need to decrease it
            else
            {
                right =mid;
            }
        }

        return left;
        
    }
}