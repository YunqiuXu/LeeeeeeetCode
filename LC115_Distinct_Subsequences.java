public class Solution {
    /** Yunqiu Xu*/
    /** given S/T, count the distinct subsequences of T in S
     * e.g. S = "rabbbit", T = "rabbit", return 3
     */
    /** two-sequences-related dp
     * state: f[i][j]: how to choose T[:j] from S[:i], number of methods
     * function:
     *   if(S[i-1] == T[j-1]){
            f[i][j] = f[i-1][j] + f[i-1][j-1]; 
                e.g. S = "rabbb", T = "rab" --> f[5][3]
                f["rabb"]["ra"] --> f[4][2]
                + f["rabb"]["rab"] --> f[4][3]
        }
     *   else{
            f[i][j] = f[i-1][j]
                 e.g. S = "rabbbit", T = "rabbi"
                f["rabbbit"]["rabbi"] = f["rabbbi"]["rabbi"]
                nothing to do with "t" in S
        }
     * initialize:
        f[i][0] = 1; //e.g. S = "abc", T = "", only one method --> subS = ""
        f[0][j] = 0; //j > 0, S = "" --> no methods to get T from S
     * answer:
        f[S.size()][T.size()]
     */
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return -1;
        }
        int m = s.length();
        int n = t.length();

        int[][] result = new int[m+1][n+1];
        
        for(int i = 0;i < m+1; i++){
            result[i][0] = 1;
        }
        
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    result[i][j] = result[i-1][j] + result[i-1][j-1];
                }
                else{
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[m][n];
    }
}
