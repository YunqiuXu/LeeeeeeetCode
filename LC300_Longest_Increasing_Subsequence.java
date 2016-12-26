public class Solution {
    /** Yunqiu Xu*/
    /** axis-related dp
     * state:
     *      f[i] --> the LIS when I jump to position i
     *      note that if single-sequence-related, f[i] and f[j] are not related
     * function: 
     *      f[i] = max{f[j] + 1}, nums[j] <= nums[i]
     * initialize:
     *      all f[i] = 1
     * answer:
     *      max(f[i])
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] result = new int[nums.length];
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            result[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(result[j] + 1 > result[i]){
                        result[i] = result[j] + 1;
                    }
                }
            }
            if(result[i] > max){
                max = result[i];
            }
        }
        
        return max;
    }
}
