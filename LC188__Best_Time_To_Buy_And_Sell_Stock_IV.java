public class Solution {
    /** Yunqiu Xu*/
    //II和III的综合体
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int n = prices.length;
        if(k > n / 2){
            return maxProfitII(prices);
        }
        
        int[][] dp = new int[k+1][n];
        
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        
        return dp[k][n-1];
    }
    
    //若k > n / 2则等价于可交易无限次, 同II
    private int maxProfitII(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
    
}
