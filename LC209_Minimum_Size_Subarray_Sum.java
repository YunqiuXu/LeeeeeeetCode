public class Solution {
    /** Yunqiu Xu*/
    /** 双指针start / end
     * 首先不断增加end直到sum > s
     * 然后不断减去start
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int currSum = 0;
        int currMin = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        
        while(end < nums.length){
            //首先找到不小于s的序列和
            while(currSum < s && end < nums.length){
                currSum += nums[end];
                end++;
            }
            //从头不断减少
            if(currSum >= s){
                while(currSum >= s && start < end){
                    currSum -= nums[start];
                    start++;
                }
                //注意结束循环时start大了1
                currMin = Math.min(currMin, end-start+1);
            }
        }
        return (currMin == Integer.MAX_VALUE) ? 0 : currMin;
    }
}
