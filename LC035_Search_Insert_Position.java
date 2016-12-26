public class Solution {
    /** Yunqiu Xu*/
    
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        if(target < nums[start]){
            return 0;
        }
        if(target > nums[end]){
            return nums.length;
        }
        //find the smallest element that <= target
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }
            else if(nums[mid] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(nums[start] >= target){
            return start;
        }
        if(nums[end] >= target){
            return end;
        }
        return -1;
    }
}
