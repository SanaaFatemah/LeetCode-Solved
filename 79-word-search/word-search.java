class Solution {
    private int[][] dirs;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {

        if (board == null)
            return false;
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int i, int j) {
        // base
        if (idx == word.length())
            return true;
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0||board[i][j] == '#') return false;
        //if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            //return false;
        // logic
        if (board[i][j] == word.charAt(idx)) {

            // action
            board[i][j] = '#';
            // recurse
            for (int[] dir : dirs) {
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                if (backtrack(board, word, idx + 1, nr, nc))
                    return true;
            }
            // backtrack
            board[i][j] = word.charAt(idx);

        }

        return false;
    }

}
