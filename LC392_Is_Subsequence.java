public class Solution {
    /** Yunqiu Xu*/
    /** Method 1 : similar to LCS, but exceed memory!!
     * state: lcs[4][4] --> lcs["ABCD"]["EACB"]
     * function: 
        lcs["ABCD"]["EACB"] = max(lcs["ABCD"]["ABC"], lcs["ABC"]["EACB"])
        if(a[i] == b[j]){
            f[i][j] = max(f[i-1][j], f[i][j-1], f[i-1][j-1] + 1)
        }
        else{
            //"f[i-1][j-1]+0" can be omitted
            f[i][j] = max(f[i-1][j], f[i][j-1]) 
        }
    * initialize: f[i][0] = 0, f[0][j] = 0
    * answer: f[a.length()][b.length()] == a.length()
    */
    /* public boolean isSubsequence(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        int m = s.length();
        int n = t.length();
        int[][] result = new int[m+1][n+1];
        
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    result[i][j] = Math.max(Math.max(result[i-1][j], result[i][j-1]), result[i-1][j-1] + 1);
                }
                else{
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }
        
        return result[m][n] == m;
    }*/
    /** Method 2: A very easy method*/
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0){
            return true;
        }
        int indexS = 0;
        for(int indexT = 0; indexT < t.length(); indexT++){
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
