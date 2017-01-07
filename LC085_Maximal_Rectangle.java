public class Solution {
    /** Yunqiu Xu*/
    //这个题基于LC221Maximal Square 以及 LC084 Largest Rectangle in Histogram
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        int result = 0;
        
        //初始化第一行第一列为1
        for(int i = 0; i < m; i++){
            height[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        for(int j = 0; j < n; j++){
            height[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            result = Math.max(result, largestRectangleArea(height[i]));
        }
        return result;
    }
    
    //照搬LC084,求直方图面积
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i <= heights.length; i++){
            int curr = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && curr <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, h * w);
            }
            stack.push(i);
        }
        return result;
    }
    
}
