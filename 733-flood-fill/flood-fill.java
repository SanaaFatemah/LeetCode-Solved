class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image.length == 0 || image == null) return image;
        int orgColor = image[sr][sc];
        if(orgColor == color) return image;
        int [][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};

        dfs(image, sr, sc, color, orgColor, dirs);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int orgColor, int [][]dirs)
    {
        //base
        if(r<0 || c<0 || r==image.length || c== image[0].length || image[r][c] != orgColor) return;
        //logic
        image[r][c] = color;
        for(int [] dir : dirs)
        {
            int nr = r+dir[0];
            int nc = c+dir[1];

            dfs(image, nr, nc, color, orgColor, dirs);
        }
    }
}
