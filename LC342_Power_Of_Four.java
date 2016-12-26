public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 1. 为2的k次方 --> 参见LC231
     * 2. 被3除余数为1
     */
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & num-1) == 0) && (num % 3 == 1); 
    }
}
