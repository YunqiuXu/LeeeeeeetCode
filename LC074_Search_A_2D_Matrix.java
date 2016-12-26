public class Solution {
    /** Yunqiu Xu*/
    /** 思路: 二分查找
     * 比较麻烦的方法: 两次二分
     * 首先每个子数组的第一个元素和target 比较,小于target且最接近target的为target所在的子数组
     * 然后在子数组内再进行二分查找
     */
    public boolean binarySearch(int[] sub, int target){
        if(sub == null || sub.length == 0){
            return false;
        }
        int start = 0;
        int end = sub.length - 1;
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if(sub[middle] == target){
                end = middle;
            }
            else if(sub[middle] > target){
                end = middle;
            }
            else{
                start = middle;
            }
        }
        if(sub[start] == target){
            return true;
        }
        if(sub[end] == target){
            return true;
        }
        return false;
    } 
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if(matrix[middle][0] == target){
                end = middle;
            }
            else if(matrix[middle][0] > target){
                end = middle;
            }
            else{
                start = middle;
            }
        }
        if(matrix[start][0] <= target && matrix[end][0] > target){
            return binarySearch(matrix[start], target);
        }
        else if(matrix[end][0] <= target){
            return binarySearch(matrix[end], target);
        }
        else{ //target is even smaller than the first element
            return false;
        }
    }
}
