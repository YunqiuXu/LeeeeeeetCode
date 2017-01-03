public class Solution {
    /** Yunqiu Xu*/
    /** Method 1 : greedy
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }*/
    //动态规划的解法还是不大懂
    /** Method 2: dp
     * state:
     * function:
     * initialize:
     * answer:
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        } 
        
        int[] global = new int[nums.length];
        int[] local = new int[nums.length];
        global[0] = nums[0];
        local[0] = nums[0];
        for(int i = 1; i < nums.length; i++)  
        {  
            local[i] = Math.max(nums[i], local[i-1]+nums[i]);  
            global[i] = Math.max(local[i], global[i-1]);  
        }  
        return global[nums.length-1];  
    }*/
    /** Method 3: prefixSum
     * sum[i:j] = prefixSum[j] - prefixSum[i-1]
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
