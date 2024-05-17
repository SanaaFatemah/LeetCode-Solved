class Solution {
    public int reverse(int x) {
        int reversed =0;
        int y = Math.abs(x);

        if (x ==0) return 0;

        while(y!=0)
        {
            int i = y%10;
            if (reversed > (Integer.MAX_VALUE-i)/10)
            {
                return 0;
            }
            reversed = reversed * 10 + i;
            
            y = y/10;
            
        }
        //System.out.println(reversed);
        
        if (x <0)
        return -1*reversed;
        else 
        return reversed;

        
         

        
    }
}