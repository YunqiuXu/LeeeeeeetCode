public class Solution {
    /** Yunqiu Xu*/
    /** Use bit manipulation XOR
     * X ^ X --> 0
     * 0 ^ X --> X
     * A ^ B ^ C ^ A ^ C --> B
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
