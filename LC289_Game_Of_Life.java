public class Solution {
    /** Yunqiu Xu*/
    /** 题意
     * 1为活细胞, 0为死细胞
     * 活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
     * 活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
     * 活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
     * 死细胞周围正好有三个活细胞，则该位置死细胞复活
     */
     /** 解法: 编解码
      * 要注意防止影响下一个点的计算
      * 使用二进制模拟细胞状态
      * 重新编码:
      *     0 : 死不变
      *     1 : 活不变
      *     2 : 活变死
      *     3 : 死变活
      * 对于一个节点来说，如果它周边的点是1或者2，就说明那个点上一轮是活的
      * 解码: 即0和2都变回0，1和3都变回1
      */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = 0;
                //判断周围位置的点当前状态是否为活
                //上
                if(i > 0){
                    lives += board[i - 1][j] == 1 || board[i - 1][j] == 2 ? 1 : 0;
                }
                //左
                if(j > 0){
                    lives += board[i][j - 1] == 1 || board[i][j - 1] == 2 ? 1 : 0;
                }
                //下
                if(i < m - 1){
                    lives += board[i + 1][j] == 1 || board[i + 1][j] == 2 ? 1 : 0;
                }
                //右
                if(j < n - 1){
                    lives += board[i][j + 1] == 1 || board[i][j + 1] == 2 ? 1 : 0;
                }
                //左上
                if(i > 0 && j > 0){
                    lives += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2 ? 1 : 0;
                }
                //右下
                if(i < m - 1 && j < n - 1){
                    lives += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ? 1 : 0;
                }
                //右上
                if(i > 0 && j < n - 1){
                    lives += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ? 1 : 0;
                }
                //左下
                if(i < m - 1 && j > 0){
                    lives += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ? 1 : 0;
                }
                //对当前点状态进行更新
                if(board[i][j] == 0 && lives == 3){ //复活
                    board[i][j] = 3;
                } 
                else if(board[i][j] == 1){ 
                    if(lives < 2 || lives > 3){ //死亡
                        board[i][j] = 2;
                    } 
                }
            }
        }
        
        //解码: 0和2都变回0，1和3都变回1
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = board[i][j] % 2;
            }
        }
        
    }
}
