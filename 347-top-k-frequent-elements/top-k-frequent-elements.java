class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mapNums = new HashMap<>();
        int res[] = new int[k];
        List<Integer> [] bucket = new List[nums.length+1];

        for (int i: nums)
        {
            if (mapNums.containsKey(i))
            {
                mapNums.put(i, mapNums.getOrDefault(i, 0) + 1);
            }
            else
            {
                mapNums.put(i, 1);
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> mapNums.get(b) - mapNums.get(a));
        
        for(int key : mapNums.keySet()){
            maxHeap.add(key);
        }
        
        
        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }
        return res;
    }
        
    
}