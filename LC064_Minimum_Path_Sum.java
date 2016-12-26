public class Solution {
    /** Yunqiu Xu
     * state: f[x][y] --> the shortest path from start to (x,y)
     * how to reach (x, y): from (x-1, y) or (x, y-1)
     * function: f[x][y] = min(f[x-1][y], f[x][y-1]) + A[x][y]
     * initiaze: 
     *      f[i][0] = sum(0, 0 ~ i, 0)
     *      f[0][i] = sum(0, 0 ~ 0, i)
     * answer: f[n-1][m-1]
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        //initialization: the 0th row and 0th column
        sum[0][0] = grid[0][0];
        for(int i = 1; i < M; i++){
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < N; i++){
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }

        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[M-1][N-1];
    }
}
