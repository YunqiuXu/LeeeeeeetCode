public class Solution {
    /** Yunqiu Xu*/
    /** Axis-related dp
     * state: f[n] --> the maximum amount of money from first nth houses
     * function:
     *      2 conditions: 
     *          do not rob this house --> f[i] = f[i-1]
     *          rob this house --> f[i] = f[i-2] + nums[i-1]
     *      f[i] = max(f[i-1], f[i-2] + nums[i-1])
     * initialize:
     *      f[0] = 0
     *      f[1] = nums[0] --> only one house
     * answer:
     *      f[n]
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] result = new int[nums.length + 1];
        result[0] = 0;
        result[1] = nums[0];
        
        for(int i = 2; i < nums.length + 1; i++){
            result[i] = Math.max(result[i-1], result[i-2]+nums[i-1]);
        }
        return result[nums.length];
    }
}
