public class Solution {
    /** Yunqiu Xu*/
    /** Method: dp
     * track the min element
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            //注意，如果nums[i]不是当前最大元素，那么profit肯定不会变咯
            if(prices[i] - min > profit){
                profit = prices[i] - min;
            }
        }
        
        return profit;
    }
}
