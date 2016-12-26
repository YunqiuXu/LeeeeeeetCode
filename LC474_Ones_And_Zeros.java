public class Solution {
    //还是不会，看了答案，还要继续理解啊擦
    /** Yunqiu Xu*/
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int s = strs.length-1; s >= 0; s--) {
            int[] count = count(strs[s]);
            for (int i = m; i >= count[0]; i--){
                for (int j = n;j >= count[1]; j--){
                    dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    
    //find the number of 0s and 1s in a string
    public int[] count(String str) {
        int[] result = new int[2];
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                result[0]++;
            }
            else{
                result[1]++;
            }
        }
        return result;
    }
}
