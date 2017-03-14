public class Solution {
    /** Yunqiu Xu
     * 按九章的搞法，这道题用动态规划做, 但是会超时
     * state: f[i] --> whether I can jump to ith position
     * function f[i] = (f[j] == true, j < i && j can reach i)
     * initialize: f[0] = true
     * answer: f[n-1]
     */
    /** Dynamic Programming
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(can[j] == true && j + nums[j] >= i){
                    can[i] = true;
                    break;
                }
            }
        }

        return can[nums.length - 1];
    }
    */
    /** Greedy */
    //正向，从0出发，一层一层网上跳，看最后能不能超过最高层，能超过，说明能到达，否则不能到达
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
