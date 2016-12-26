public class Solution {
    /** Yunqiu Xu
     * state: f[x][y] --> the number of paths from start to (x,y)
     * function: f[x][y] = f[x-1][y] + f[x][y-1]
     * initialize: f[0][i] = f[i][0] = 1
     * answer: f[n-1][m-1]
     */
    public int uniquePaths(int m, int n) {
        if(m <= 1 || n <= 1){
            return 1;
        }
        int[][] sum = new int[m][n];
        
        for(int i = 1; i < m; i++){
            sum[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            sum[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1];
            }
        }

        return sum[m-1][n-1];
    }
}
