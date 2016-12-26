public class Solution {
    /** Yunqiu Xu*/
    //思路: n为2的k次方 --> n & (n-1) == 0 
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        return (n & n-1) == 0;
    }
}
