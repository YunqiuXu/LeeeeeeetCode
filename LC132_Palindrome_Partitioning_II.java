public class Solution {
    /** Yunqiu Xu */
    /** 单序列DP中套了一个区间DP，比较难直接照搬九章的答案了，思路如下:
     * e.g. "aab" --> return 1 --> partition 1 time to "aa"+"b"
     * state : f[i] --> the least partition times for string[0:i] 
     *    or can be partitioned into i+1 substrings
     * f[0] --> "" --> -1 because f["aa"] = f[""] + 1 = 0
     * f[1] --> "a" --> 0
     * f[2] --> "aa" --> 0
     * f[3] --> "aab" --> 1 
     *    "aa|b" --> 1 + f["aa"]
     *    "a|ab" --> invalid

     * "abac|c" --> 1 + f["abac"]
     * "aba|cc" --> 1 + f["aba"]
     * function: f[i] = MIN{f[j]+1}, that satisfy:
     *    j<i && j+1 ~ i is valid
     * initialize: f[i] = i - 1 (f[0] = -1)
     * answer: f[n], n = s.length
     */
    
    //this is a interval-related DP: larger interval relies on smaller one
    //is f[i][j] is valid <--> f[i+1][j-1] is valid && s[i]==s[j]
    //e.g. "abbcbba" <--> "bbcbb" && 'a'=='a'
    private boolean[][] getIsPalindrome(String s){
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        //interval = 0 --> single letter
        for(int i = 0; i < s.length(); i++){
            isPalindrome[i][i] = true;
        }
        //interval = 1 --> two letters --> check whether they are same
        for(int i = 0; i < s.length() - 1; i++){
            isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        //interval >= 2
        for(int length = 2; length < s.length(); length++){
            for(int start = 0; start + length < s.length(); start++){
                isPalindrome[start][start+length] = isPalindrome[start+1][start+length-1] && (s.charAt(start) == s.charAt(start+length));
            }
        }
        return isPalindrome;
    }
     
     
    public int minCut(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        //preparation
        boolean[][] isPalindrome = getIsPalindrome(s);
        //initialize
        int[] f = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            f[i] = i - 1;
        }
        //main
        for(int i = 1;i <= s.length() ; i++){
            for(int j = 0; j < i; j++){
                if(isPalindrome[j][i-1] == true){
                    f[i] = Math.min(f[i], f[j]+1);
                }
            }
        }
        return f[s.length()];
    }
}
