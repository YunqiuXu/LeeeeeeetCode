public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 第一次遍历全部元素: 如果matrix[i][j] == 0，就将对应的第一行和第一列上的元素matrix[0][j], matrix[i][0]赋值为0
     * 若第一行/第一列本身存在0 --> 参数设为true
     * 第二次遍历从第二行及第二列开始, 如果对应第一行第一列为0, 将该元素设为0
     * 根据参数是否为true决定是否将第一行/第一列全设为0
     */
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        
        boolean firstRow = false;
        boolean firstColumn = false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        firstRow = true;
                    }
                    if(j == 0){
                        firstColumn = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        //第一行所有都设为0
        if(firstRow == true) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        //第一列所有都设为0
        if(firstColumn == true) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
}
