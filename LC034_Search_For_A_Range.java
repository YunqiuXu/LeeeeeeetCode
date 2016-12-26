public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 找到target, 找到第一个比target大的元素
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null || nums.length == 0){
            return result;
        }
        int begin = binarySearch(nums, target);
        if(begin == -1){
            return result;
        }
        else{//find first element larger than target;
            result[0] = begin;
            int end = nums.length - 1;
            while(begin + 1 < end){
                int mid = begin + (end - begin) / 2;
                if(nums[mid] > target){
                    end = mid;
                }
                else{//equal with target
                    begin = mid;
                }
            }
            if(nums[end] == target){
                result[1] = end;
            }
            else{
                result[1] = end - 1;
            }
            return result;
        }
    }
    
    public int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }
}
