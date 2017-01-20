//"A man, a plan, a canal: Panama" is a palindrome.
public class Solution {
    /** Yunqiu Xu*/
    /** Method 1:
     * 回文字符串翻转后和原来相同
     */
    public boolean isPalindrome(String s) {
        String fuck = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reverse = new StringBuffer(fuck).reverse().toString();
        return reverse.equals(fuck);
    }
    
    /** Method 2*/
    public boolean isPalindrome(String s) {
        String fuck = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = fuck.length() - 1;
        while (left <= right) {
            if (fuck.charAt(left++) !=  fuck.charAt(right--)){
                return false;
            } 
        }
        return true;
    }
}
