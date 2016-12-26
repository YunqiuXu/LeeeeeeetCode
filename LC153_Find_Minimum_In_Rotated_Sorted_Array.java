public class Solution {
    
    /** Yunqiu Xu*/
    /** 思路: 二分查找, 可以画下图
     * middle > start && middle > end : start = middle
     * middle < start && middle < end : end = middle
     * start < middle < end : end = middle
     * start > middle > end : start = middle
     */
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int middle = start + (end - start)/2;
            if(nums[middle] >= nums[start] && nums[middle] >= nums[end]){
                start = middle;
            }
            else if(nums[middle] <= nums[end] && nums[middle] <= nums[start]){
                end = middle;
            }
            else if(nums[middle] >= nums[start] && nums[middle] <= nums[end]){
                end = middle;
            }
            else{
                start = middle;
            }
        }
        if(nums[start] < nums[end]){
            return nums[start];
        }
        else{
            return nums[end];
        }
    }
}
