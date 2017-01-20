public class Solution {
    /** Yunqiu Xu*/
    /** Method:
     * 对于每一个字符，以之作为中间元素往左右寻找
     * 注意处理奇(aba)偶(abba)两种模式
     */
     
    private int startIndex, maxLength;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
    
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //odd --> 以该位置为中点创建
            extendPalindrome(s, i, i+1); //even --> 以i,i+1为中点创建
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
    
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLength < k - j - 1) {
            startIndex = j + 1;
            maxLength = k - j - 1;
        }
    }
}
