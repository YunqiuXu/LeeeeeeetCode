public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * output[i] =  { i 前面的数的乘积}  X  { i 后面的数的乘积}
     * 首先从前向后扫描, 得到i 前面的数的乘积
     * e.g. [1,2,3,4] --> [1,1,2,6]
     * 然后从后向前扫描, 得到i 后面的数的乘积
     * e.g. [1,2,3,4] --> [24, 12, 4, 1]
     * 两两相乘得到最后结果
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        forward[0] = 1;
        backward[nums.length-1] = 1;
        
        for(int i = 1; i < nums.length; i++){
            forward[i] = forward[i-1] * nums[i-1]; 
        }
        
        for(int j = nums.length - 2; j >= 0; j--){
            backward[j] = backward[j+1] * nums[j+1]; 
        }
        
        for(int k = 0; k < nums.length; k++){
            result[k] = forward[k] * backward[k];
        }
        
        return result;
    }
    
    /** O(1) space*/
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length-1]=1;
        for(int i = nums.length - 2; i >= 0; i--){
            result[i]=result[i+1] * nums[i+1];
        }
    
        int forward = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = result[i] * forward;
            forward = forward * nums[i];
        }
        
        return result;
    }
}
