public class Solution {
    /** Yunqiu Xu*/
    /** Given 3 strings s1/s2/s3 
     * check whether s3 is formed by interleaving of s1 and s2
     * s1 = "aabcc", s2 = "dbbca"
     * s3 = "aadbbcbcac" --> true (s3 = s1 + s2)
     * s3 = "aadbbbaccc" --> false
     */
    /** double-sequences-related dp
     * state: 
        f[i][j] --> whether s3 can be formed by s1[:i] + s2[:j]
     * function: 
        f[i][j] = (f[i-1][j] && (s1[i-1] == s3[i+j-1])) || (f[i][j-1] && (s2[j-1] == s3[i+j-1]));
     * initialize:
        f[0][0] = true;
        f[i][0] = (s1[0...i-1] == s3[0...i-1]); 前面全对
        f[0][j] = (s2[0...j-1] == s3[0...j-1]); 前面全对
     * answer:
        f[s1.size()][s2.size()]
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        int m = s1.length();
        int n = s2.length();
        boolean[][] result = new boolean[m+1][n+1];
        
        //注意初始化这里和之前的模板不一样
        result[0][0] = true;
        for(int i = 1;i < m+1; i++){
            result[i][0] = (s1.charAt(i-1) == s3.charAt(i-1)) && result[i-1][0] ;
        }
        for(int j = 1;j < n+1; j++){
            result[0][j] = (s2.charAt(j-1) == s3.charAt(j-1)) && result[0][j-1];
        }
        
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                result[i][j] = (result[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1))) || (result[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
        
        return result[m][n];
    }
}
