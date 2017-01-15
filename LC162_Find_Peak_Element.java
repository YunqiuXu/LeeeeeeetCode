public class Solution {
    /** Yunqiu Xu*/
    /**binary search*/
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <= 1){ //若只有一个元素直接返回0
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) { //peak在mid右边
                start = mid;
            } 
            else {
                end = mid;
            }
        }
        
        if( nums[start] < nums[end]) {
            return end;
        } 
        else { 
            return start;
        }
    }
}
