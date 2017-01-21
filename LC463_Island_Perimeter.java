public class Solution {
    /** Yunqiu Xu*/
    /** 计算岛屿周长
     * 每增加一块陆地, 周长加4
     * 当前陆地的左边也是陆地, 周长减2
     * 当前陆地的上边也是陆地, 周长减2
     */
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    result += 4;
                    if(i > 0 && grid[i-1][j] == 1){
                        result -= 2;
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        result -= 2;
                    }
                }
            }
        }
        
        return result;
    }
}
