public class Solution {
    /** Yunqiu Xu */
    /** Find the minimum steps to convert str1 to str2
     * Insert a char
     * Delete a char
     * Replace a char
     */
    /** Method: similar to LCS
    * state: f[i][j] --> the min steps to convert a[:i] to b[:j]
    * function: 
    *    if(a[i] == b[j]){
    *        f[i-1][j]+1 --> del a[i]
    *        f[i][j-1]+1 --> add a[i]
    *        f[i][j] = MIN(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1])
    *    }
    *    else{
    *       f[i][j] = MIN(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1)
    *    }
    * initialize: 
    *    f[i][0] = i; //del i elements
    *    f[0][j] = j; //add j elements
    * answer: f[a.length()][b.length()]
    */
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return -1;
        }
        int m = word1.length();
        int n = word2.length();
        int[][] result = new int[m+1][n+1];
        
        for(int i = 0;i < m+1; i++){
            result[i][0] = i;
        }
        for(int j = 0;j < n+1; j++){
            result[0][j] = j;
        }
        
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    result[i][j] = Math.min(Math.min(result[i-1][j]+1, result[i][j-1]+1), result[i-1][j-1]);
                }
                else{
                    result[i][j] = Math.min(Math.min(result[i-1][j]+1, result[i][j-1]+1), result[i-1][j-1]+1);
                }
            }
        }
        
        return result[m][n];
    }
}
