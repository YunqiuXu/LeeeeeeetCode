public class Solution {
    /** Yunqiu Xu*/
    //和之前的区别在于可以多次买卖, 但注意买需要发生在卖前面
    //但这个方法真的略简单诶
    public int maxProfit(int[] prices) {
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
