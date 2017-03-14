public class Solution {
    /** Yunqiu Xu*/
    /** DP
     * M (j) is the minimum number of coins required to make change for cost j
     * if j = 0 --> M(j) = 0
     * else --> M(j) = min(M(j - c0), M(j - c1), M(j - c2)...) + 1
     * 
     * total time complexity: O(amount * coins.length)
     */
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount <= 0){
            return 0;
        }
        
        int[] M = new int[amount+1];
        // init
        for(int i = 1; i < M.length; i++){
            M[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i < M.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && M[i - coins[j]] != Integer.MAX_VALUE){
                    M[i] = Integer.min(M[i], M[i - coins[j]] + 1);
                }
            }
        }
        
        return M[amount] == Integer.MAX_VALUE ? -1 : M[amount];
    }
}
