class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        //Step 1 : get the indices of all the rotten oranges and count of the fresh oranges
        //Add the address of the rotten ones in the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int time = 0;

        //Step 2: Using BFS process each level of rotten oranges
        while (!q.isEmpty()) {
            int size = q.size();
            //Making sure to process each batch together
            for (int i = 0; i < size; i++) {
                //Extracting one rotten orange
                int[] curr = q.poll();
                //Exploring its neighbors
                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    //Checking index out of bounds and if the neighbor is a fresh orange
                    if (nr >= 0 && nc >= 0 && nc < n && nr < m && grid[nr][nc] == 1) {
                        q.add(new int[] { nr, nc });
                        //Mutating the grid to mark it as rotten now
                        grid[nr][nc] = 2;
                        //Decreasing the fresh count
                        fresh--;
                    }
                }
            }
            time++;
        }
        if (fresh == 0)
            return time - 1;
        else
            return -1;

    }
}