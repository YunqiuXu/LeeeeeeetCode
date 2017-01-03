public class Solution {
    /** Yunqiu Xu*/
    /** Method: dp
     * track the min element
     * this is similar to Maximum Subarray
     * e.g. [3,2,3,1,2] can be transfered as [-1,1,-2,1]
     * if we buy in Day 0 and sell in Day 1 --> profit is -1
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){\
            //min 代表在最低价买入
            min = Math.min(min, prices[i]);
            //注意，如果nums[i]不是当前最大元素，那么profit肯定不会变咯
            profit = Math.max(profit, prices[i] - min);
            
        }
        
        return profit;
    }
}
