public class Solution {
    //看了下答案, 还需继续理解!! 这里我泛化了III, 与IV做法相同
    /** Yunqiu Xu*/
    /** Method: dp
    * state: dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
    * function: dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
    *                    = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
    * init: dp[0, j] = 0; 0 transactions makes 0 profit
    *       dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
    * answer: dp[k][n-1]
    */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int n = prices.length;
        int k = 2;
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
}
