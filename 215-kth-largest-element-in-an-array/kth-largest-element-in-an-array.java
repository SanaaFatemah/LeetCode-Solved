class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //Maintaining a range of k elements in the heap so that once all the elements are added only the top kth element can be accessed
        for(int i=0; i<k; i++)
        {
            heap.offer(nums[i]);
        }
        //checking through the other numbers to see if any number is bigger than the smallest number 
        //currently in the heap. if it is bigger than that, we will add it to the heap 
        //becasue we want to get the kth largest element and the queue will make sure to sort it for us
        for(int i=k; i<nums.length; i++)
        {
            if(heap.peek() < nums[i])
            {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
}