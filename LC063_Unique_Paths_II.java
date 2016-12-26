public class Solution {
    /** Yunqiu Xu
     * LC062:
     * state: f[x][y] --> the number of paths from start to (x,y)
     * function: f[x][y] = f[x-1][y] + f[x][y-1]
     * initialize: f[0][i] = f[i][0] = 1
     * answer: f[n-1][m-1]
     * 不同点:需要处理障碍物, 对于有障碍物的点，sum = 0
     * 思路: 不进行初始化，在后面进行判断
     * sum[i][0] = sum[i-1][0]
     * sum[0][i] = sum[0][i-1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] sum = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    sum[i][j] = 0;
                }
                else if(i == 0 && j == 0){
                    sum[i][j] = 1;
                }
                else if(i == 0){
                    sum[i][j] = sum[i][j-1];
                }
                else if(j == 0){
                    sum[i][j] = sum[i-1][j];
                }
                else{
                    sum[i][j] = sum[i-1][j] + sum[i][j-1];
                }
            }
        }

        return sum[m-1][n-1];
    }
}
