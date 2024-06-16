class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<int[]> queue = new LinkedList<>();
        int [][] dirs = new int [][]{ { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int m = image.length;
        int n = image[0].length;
        int org = image[sr][sc];
        if(org == color) return image;

        queue.add(new int [] {sr, sc});
        image[sr][sc] = color;
        while(!queue.isEmpty())
        {
            int [] curr = queue.poll();

            for(int [] dir: dirs)
            {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr < m && nc < n && nr >=0 && nc >= 0 && image[nr][nc] == org)
                {
                    queue.add(new int [] {nr, nc});
                    
                    image[nr][nc] = color;
                }
            }
        }

        return image;


        
    }
}