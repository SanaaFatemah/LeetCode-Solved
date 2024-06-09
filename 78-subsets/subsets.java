class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,new ArrayList<>(),nums,0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> output,int[] nums,int start)
    {
        if(start==nums.length){
             result.add(new ArrayList<>(output));
             return;
        }
            output.add(nums[start]);
            helper(result,output,nums,start+1);
            System.out.println("res "+result+" out "+output+" start "+start);
            output.remove(output.size()-1);
            helper(result,output,nums,start+1);
  
    }
}