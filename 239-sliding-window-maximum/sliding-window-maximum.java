class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n-k+1];
        int ri =0;
        //using a doubly linked list to push and pop from either ends
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i =0;i<n;i++)
        {
            //if an element that is out of bounds of tht given window size is present, remove it
            if(!queue.isEmpty() && queue.peek() == i-k) queue.poll();

            //checking if the values of the queue are in decreaing order
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
            {
                queue.pollLast();
            }
            //we add the index of the element in the queue
            queue.offer(i);

            //adding the maximum in the window into the res array
            if(i>=k-1)
            {
                res[ri++] = nums[queue.peek()];
            }

        }

        return res;
        
    }
}