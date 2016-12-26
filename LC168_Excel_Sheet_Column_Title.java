public class Solution {
    /** Yunqiu Xu
     * 有固定套路的数学问题
     */
    public String convertToTitle(int n) {
        String result = "";
        while(n != 0) {
            n--;
            char curr = (char)(n % 26 + 'A');
            result = curr + result;
            n /= 26;
        }
        return result;
    }
}
