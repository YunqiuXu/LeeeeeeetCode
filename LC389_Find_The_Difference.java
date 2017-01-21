public class Solution {
    /** Yunqiu Xu*/
    /**Method 1 : bit manipulation, similar to LC136 */
    public char findTheDifference(String s, String t) {
        String total = s + t;
        char result = total.charAt(0);
        for(int i = 1; i < total.length(); i++){
            result ^= total.charAt(i); //注意不能用result = result ^ total.charAt(i), char不支持
        }
        return result;
    }
    
    /** Method 2: hash table, not recommend*/
}
