public class Solution {
    /** Yunqiu Xu
     * state: f[x][y] --> the the shortest path from start to (x,y)
     * function: f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + A[i][j]
     * initialize: 
     *      f[0][0] = A[0][0];
     *      f[i][0] = f[i-1][0] + A[i][0]; only one way
     *      f[i][i] = f[i-1][i-1] + A[i][i]; only one way
     * answer: Math.min(f[n-1][0], f[n-1][1], f[n-1][2], ...)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        int M = triangle.size();
        int[][] sum = new int[M][M];
        
        //initialization
        sum[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < M; i++){
            sum[i][0] = sum[i-1][0] + triangle.get(i).get(0);
            sum[i][i] = sum[i-1][i-1] + triangle.get(i).get(i);
        }
        
        //top-down
        for(int i = 1; i < M; i++){
            for(int j = 1; j < i; j++){
                sum[i][j] = Math.min(sum[i-1][j], sum[i-1][j-1]) + triangle.get(i).get(j);
            }
        }
        
        //find the answer
        int minSum = sum[M-1][0];
        for(int i = 1; i < M; i++){
            if(minSum > sum[M-1][i]){
                minSum = sum[M-1][i];
            }
        }
        return minSum;
    }
}
