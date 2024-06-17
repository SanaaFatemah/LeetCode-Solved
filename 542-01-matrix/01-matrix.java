class Solution {
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();
        int [][] dirs = new int [][]{{1,0},{0,1}, {0,-1},{-1,0}};

        int m = mat.length;
        int n = mat[0].length;

        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 0)
                {
                    queue.add(new int []{i,j});
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }

        int dist =1;

        while(!queue.isEmpty())
        {
           int size = queue.size();
            for(int i=0;i<size;i++)
            {   
                System.out.println(queue.size() + "dist "+ dist);
                int [] curr = queue.poll();

                for(int [] dir:dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    
                    if(nr >=0 && nc >=0 && nr < m && nc < n && mat[nr][nc] == -1)
                    {
                        System.out.println("Curr "+curr[0] +" " + curr[1]);
                        System.out.println(nr +" " + nc);
                        System.out.println(mat[nr][nc]);
                        //System.out.println("dist " + dist);
                        mat[nr][nc] = dist;
                        queue.add(new int []{nr,nc});
                    }
                    //}
                }
            }
            dist++;
            
            
        }
        

        return mat;
        
    }
}