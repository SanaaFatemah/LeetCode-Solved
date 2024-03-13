class Solution {
    public void setZeroes(int[][] matrix) {
        //Using 2 single dimension arrays to record where the 0's are placed. 
        //once they are recorded, will traverse the array again to mark them those recorded rows and cols as 0
        int [] row = new int[matrix.length];
        int [] col = new int[matrix[0].length];
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);

        for (int i=0;i<matrix.length; i++)
        {
            for(int j=0;j<matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i=0;i<matrix.length; i++)
        {
            for(int j=0;j<matrix[0].length; j++)
            {
                if(row[i] == 1|| col[j] == 1)
                {
                    matrix[i][j] = 0;
                }
            }
        }

       

        
    }
}