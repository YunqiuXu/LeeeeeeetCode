public class Solution {
    /** Yunqiu Xu*/
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if(nums[middle] == target){
                return true;
            }
            //condition 1: right is sorted, or left is unsorted
            if(nums[middle] < nums[end] || nums[middle] < nums[start]){
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle;
                } 
                else{
                    end = middle;
                }
            }
            //condition 2: left is sorted, or right is unsorted
            else if(nums[middle] > nums[start] || nums[middle] > nums[end]){
                if (target < nums[middle] && target >= nums[start]) {
                    end = middle;
                } else {
                    start = middle;
                }
            }
            //nums[start] == nums[mid] == nums[end]
            else{
                end--;
            }
        }
        if(nums[start] == target){
            return true;
        }
        if(nums[end] == target){
            return true;
        }
        return false;
    }
}

