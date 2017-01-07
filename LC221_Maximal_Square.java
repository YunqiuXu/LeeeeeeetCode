public class Solution {
    /** Yunqiu Xu*/
    /** DP
     * state: f[i][j] = the side length of square start at (i,j)
     * function:
     *      if matrix(i,j) == 1 
     *          f[i][j] = min(f[i-1][j], f[i][j-1], f[i-1][j-1]) + 1
     *      else
     *          f[i][j] = 0
     * init: 
     *      f[i][0] = matrix(i,0)
     *      f[0][j] = matrix(0,j)
     * answer: max(f[i][j])
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        int output = 0;
        
        for(int i = 0; i < m; i++){
            f[i][0] = matrix[i][0] == '1' ? 1 : 0;
            output = Math.max(output, f[i][0]);            
        }
        
        for(int j = 0; j < n; j++){
            f[0][j] = matrix[0][j] == '1' ? 1 : 0;
            output = Math.max(output, f[0][j]);            
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    f[i][j] = Math.min(Math.min(f[i-1][j], f[i][j-1]), f[i-1][j-1]) + 1;
                }
                output = Math.max(output, f[i][j]);
            }
        }
        
        return output * output;
    }
}
