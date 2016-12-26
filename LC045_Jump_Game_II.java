public class Solution {
    //看了答案，还需继续理解！！
    /** Yunqiu Xu
     * Dynamic Programming: 代码正确但是会超时
     * state: f[i] --> the shortest steps to reach ith position
     * function: f[i] = MIN{f[j]+1, j<i && j can reach i}
     * initialize: f[0] = 0
     * answer: f[n-1]
     */
     /**public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for(int i = 1; i < nums.length; i++){
            steps[i] = Integer.MAX_VALUE; //init: can not reach
            for(int j = 0; j < i; j++){
                if(steps[j] != Integer.MAX_VALUE && j + nums[j] >= i){
                    //Version 1:
                    //steps[i] = steps[j] + 1;
                    //break;
                    //Version 2:
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                 }
            }
        }
        return steps[nums.length - 1];
    }*/
    /** 九章的Greedy，还是不大理解
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = 0;
        int jumps = 0;
        
        while(end < nums.length - 1){
            jumps++;
            int farthest = end;
            for(int i = start; i <= end; i++){
                if(nums[i] + i > farthest){
                    farthest = nums[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
    */
    /** Leetcode 的答案，要简单一些，只需要单循环*/
    /**
     * step_count: result
     * last_jump_max: longest distance in last minimum step
     * current_jump_max: longest distance in current minimum step
     */
    public int jump(int[] A) {
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for(int i=0; i<A.length-1; i++) {
            current_jump_max = Math.max(current_jump_max, i+A[i]);
            if( i == last_jump_max ) {
                step_count++;
                last_jump_max = current_jump_max;
            } 
        }
        return step_count;
    }
}
    
