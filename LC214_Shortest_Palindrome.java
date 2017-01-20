public class Solution {
    /** Yunqiu Xu*/
    //这题还可以用KMP做, 之后可以复习一下
    /** Method: find the longest palindrome prefix
     *  then reverse the remaining part as the prefix to s
     */
    public String shortestPalindrome(String s) {
        int i = 0;
        int end = s.length() - 1;
        int j = end;
        char chs[] = s.toCharArray(); //注意一定要这一步, charAt()会超时
        while(i < j) {
            if (chs[i] == chs[j]){
                i++; 
                j--;
            } 
            else { 
                //not palindrome --> check whether s[i to end] is palindrome
                i = 0; 
                end--; 
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
