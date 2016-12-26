//"A man, a plan, a canal: Panama" is a palindrome.
public class Solution {
    /** 思路
     * 回文字符串翻转后和原来相同
     */
    public boolean isPalindrome(String s) {
        String fuck = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reverse = new StringBuffer(fuck).reverse().toString();
        return reverse.equals(fuck);  
    }
}
