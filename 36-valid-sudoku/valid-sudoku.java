class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            //The calculation i / 3 determines which row block the current row belongs to, 
            //and then multiplying it by 3 gives the starting row index of that block.
            int RowIndex = 3*(i/3);
            //The calculation i % 3 determines the column block within which the current row belongs, 
            //and then multiplying it by 3 gives the starting column index of that block.
            int ColIndex = 3*(i%3);
        Set<Character> rows = new HashSet<Character>();
        Set<Character> columns = new HashSet<Character>();
        Set<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            // This expression calculates the row index of the current cell within the 3x3 subgrid
            //RowIndex = gives the row block of the cell
            //j/3 determines which row within the subgrid the current cell belongs to (it ranges from 0 to 2).

            //This expression calculates the column index of the current cell within the 3x3 subgrid.
            //j%3 determines which column within the subgrid the current cell belongs to (it ranges from 0 to 2).
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
    }
}