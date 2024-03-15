class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i =1; i<prices.length; i++)
        {
           int diff = prices[i] - minPrice;
           maxProfit = Math.max(diff, maxProfit);    
           minPrice = Math.min(minPrice, prices[i]);    
        }
        return maxProfit;
        
    }
}