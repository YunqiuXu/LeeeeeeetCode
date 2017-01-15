public class Solution {
    /** Yunqiu Xu*/
    //这两个题需要再看下, 没什么算法内容但是循环比较复杂
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int val = 1; 
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            //Right
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = val++; 
            }
            rowStart++;
            
            //Down
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = val++;
            }
            colEnd--;
            
            //Left
            //注意这里不需要和前面那样加if判断了
            for (int i = colEnd; i >= colStart; i--) {
                matrix[rowEnd][i] = val++;
            }
            rowEnd--;
            
            //Up
            for (int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = val++;
            }
            colStart++;
        }
        
        return matrix;
    }
}
