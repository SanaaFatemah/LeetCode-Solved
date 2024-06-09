class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,new ArrayList<>(),n,1, k);
        return result;
        
    }

    private void helper(List<List<Integer>> result, List<Integer> output,int n,int start, int k)
    {
        if(output.size() == k){
             result.add(new ArrayList<>(output));
             return;
        }
        for(int i =start;i<=n;i++)
        {
            output.add(i);
            helper(result,output,n,i+1, k);
            //System.out.println("res "+result+" out "+output+" start "+start);
            output.remove(output.size()-1);
            //helper(result,output,nums,start+1);
        }
            
  
    }
}