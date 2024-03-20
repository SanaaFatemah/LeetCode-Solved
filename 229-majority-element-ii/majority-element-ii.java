class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        List <Integer> result = new ArrayList<>();

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i=0; i < n ; i++)
        {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) +1);
        }

        //n = n /2;

        for (Map.Entry<Integer, Integer> entry: countMap.entrySet())
        {
            if ( entry.getValue() > n/3)
            {
                result.add(entry.getKey());
            }
        }

        return result;
        
    }
}