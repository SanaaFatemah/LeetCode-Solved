class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
        
    }

    private void helper(int[] candidates, int target, int pivot,List<Integer> path, List<List<Integer>> result)
    {
        if(target < 0 || pivot == candidates.length) return;
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot; i<candidates.length; i++)
        {
            //action
            path.add(candidates[i]);
            //recursion
            helper(candidates, target - candidates[i],i, path ,result);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}