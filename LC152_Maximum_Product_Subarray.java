public class Solution {
    /** Yunqiu Xu*/
    //因为存在负负得正的问题, 需要同时跟踪最小值
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int currMax = nums[0];
        int currMin = nums[0];
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = currMax;
            currMax = Math.max(Math.max(currMax*nums[i], currMin*nums[i]), nums[i]);
            currMin = Math.min(Math.min(temp*nums[i], currMin*nums[i]), nums[i]);
            if(result < currMax){
                result = currMax;
            }
        }
        
        return result;
    }
}
