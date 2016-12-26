public class Solution {
    /** Yunqiu Xu
     * state: f[i] --> the sum of methods to ith position
     * function: f[i] = f[i-1] + f[i-2]
     *      f[i-1], then add 1 stair
     *      f[i-2], then add 2 stairs
     * initialize: f[0] = 1, f[1] = 2 
     * answer: f[n]
     */
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        
        int[] sum = new int[n];
        sum[0] = 1;
        sum[1] = 2;
        //general condition: n > 2
        for(int i = 2; i < n; i++){
            sum[i] = sum[i-1] + sum[i-2];
        }
        
        return sum[n-1];
    }
}
