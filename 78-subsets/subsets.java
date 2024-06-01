class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        helper(nums, 0, res, new ArrayList<Integer>());

        return res;

    }

    public void helper(int[] nums, int start, List<List<Integer>> res, ArrayList<Integer> tmp) {
        // base
        res.add(new ArrayList<>(tmp));
        // recursion
        for (int i = start; i < nums.length; i++) {

            tmp.add(nums[i]);

            helper(nums, i + 1, res, tmp);

            // backytack
            tmp.remove(tmp.size() - 1);
        }

    }

}