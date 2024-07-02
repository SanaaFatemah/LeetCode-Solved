class Solution {
    public int countBattleships(char[][] board) {
	//count of our battleships
	int n = 0;
    int [][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

	//iterate thru the board
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[i].length; j++) {
			//check if we hit a battleship
			if (board[i][j] == 'X') {
				//increment count
				n++;
				//sink ship
				DFS(board, i, j, dirs);
			}
		}
	}

	//result
	return n;
}

//recursive helper method for DFS (sink the ships)
private void DFS(char[][] board, int i, int j, int [][] dirs) {
	//sink current piece (change to dot)
	board[i][j] = '.';

    for(int dir[]:dirs)
    {
        int nr = i+dir[0];
        int nc = j+dir[1];

        if(nr >= 0 && nr < board.length && nc < board[0].length && nc >= 0 && board[nr][nc] == 'X')
        {
            DFS(board, nr, nc, dirs);
        }
    }
	//up
	// if (i > 0 && board[i-1][j] == 'X') {
	// 	DFS(board, i-1, j);
	// }

	// //down
	// if (i < board.length - 1 && board[i+1][j] == 'X') {
	// 	DFS(board, i+1, j);
	// }

	// //left
	// if (j > 0 && board[i][j-1] == 'X') {
	// 	DFS(board, i, j-1);
	// }

	// //right
	// if (j < board[i].length - 1 && board[i][j+1] == 'X') {
	// 	DFS(board, i, j+1);
	// }
}
}