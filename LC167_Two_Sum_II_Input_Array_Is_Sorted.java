public class Solution {
    /** Yunqiu Xu*/
    public int[] twoSum(int[] numbers, int target) {
        int curr = 0;
        int[] result = new int[2];
        while(numbers[curr] <= target){
            //find target - numbers[curr] in the rest of array
            int end = binarySearch(numbers, curr, numbers.length - 1, target - numbers[curr]);
            if(end != -1){
                result[0] = curr + 1;
                if(curr == end){
                    end++;
                }
                result[1] = end + 1;
                return result;
            }
            curr++;
        }
        return result;
    }
    
    public int binarySearch(int[] nums,int start,int end, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
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
