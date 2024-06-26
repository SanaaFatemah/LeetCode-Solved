class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean [][] board = new boolean[n][n];

        backTrack(board, 0); 
        return result;      
    }

    public void backTrack(boolean [][] board, int i)
    {
        //base
        if(i==board.length)
        {
            List<String> li = new ArrayList<>();
            for(int r =0; r<board.length; r++)
            {
                StringBuilder sb = new StringBuilder();
                for(int c=0; c<board.length; c++)
                {
                    if(board[r][c]) sb.append("Q");
                    else
                    sb.append(".");
                }
                li.add(sb.toString());
            }

            result.add(li);
            return;

        }

        //logic
        for(int j=0;j<board[0].length;j++)
        {
            if(isSafe(board, i, j))
            {
                board[i][j] = true;

                backTrack(board, i+1);
                //Once all the column values of the row are explored, the function execution for that function call for that 
                //i values finishes and stack.pop happens where the previous rows's call pops out and we backtrack that row's queen placement
                //because placing the queen there can't make it possible to place a queen in the below row.
                board[i][j] = false;
            }
        }
    }

    private boolean isSafe(boolean [][] board, int r, int c)
    {
        for(int i=0; i<r; i++)
        {
            //System.out.println(i +" "+ c);
            if(board[i][c]) return false;
        }
            
            int i = r;
            int j = c;

            while(i >= 0 && j >=0)
            {
                if(board[i][j]) return false;
                i--;j--;
            }

            i = r;
            j = c;

            while(i >= 0 && j < board[0].length)
            {
                if(board[i][j]) return false;
                i--;j++;
            }

            return true;
        
    }
}