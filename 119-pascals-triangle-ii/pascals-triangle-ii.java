class Solution {
    public Integer getFactorial(int r, int c)
    {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < c; i++) {
            res = res * (r - i);
            res = res / (i + 1);
        }
        return (int)res;
    }

    public List<Integer> getRow(int rowIndex) {
         //List<List<Integer>> ans = new ArrayList<>();

        //for (int row = 1; row <= numRows; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            
            //running the loop till the row value(1 indexed)
            for (int c = 1; c <= rowIndex+1; c++)  {
                tempLst.add(getFactorial(rowIndex, c - 1));
            }
            //ans.add(tempLst);
        //}
        return tempLst;
        
    
        
        
    }
}