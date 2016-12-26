public class Solution {
    /** Yunqiu Xu*/
    /** An example
     * x = -123
     * result = -3, x = -12
     * result = -32, x = -1
     * result = -321, x = 0
     */
    public int reverse(int x) {
        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) result;
    }
}
