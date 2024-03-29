class Solution {
    public int minCost(String colors, int[] neededTime) {

        char[] ch = colors.toCharArray();
        int curTotal = 0;
        //int time =0;
        int minTime = 0;
        int j =0;

        for (int i = 1; i < ch.length;i++)
        {
            if(ch[i] == ch[i-1])
            {
                
                curTotal = curTotal + Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
                
            }
        }

        return curTotal;
        
    }
}