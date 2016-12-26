public class Solution {
    /** Yunqiu Xu*/
    /** 比较麻烦的办法: 基于LC153, 多次二分查找
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int minIndex = findMin(nums);
        
        if(start == minIndex){ //ascending order
            return binarySearch(nums, start, end, target);
        }
        if(end == minIndex){ //ascending order except the last one
            if(nums[end] == target){
                return end;
            }
            return binarySearch(nums, start, end - 1, target);
        }
        //start < minIndex < end
        int front = binarySearch(nums, start, minIndex - 1, target);
        if(front != -1){
            return front;
        }
        else{
            return binarySearch(nums, minIndex, end, target);
        }
    }
    
    //Basic binary search
    public int binarySearch(int[] nums, int start, int end, int target){
        if(nums == null || start > end){
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
    
    //findMin: find the index of minimum element of array
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
            return start;
        }
        else{
            return end;
        }
    }
    */
    
    /** Method 2: 只做一次二分查找 */
    /**public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if(nums[middle] == target){
                return middle;
            }
            //nums[middle] < nums[end] < nums[start] || nums[end] > nums[middle] > nums[start]
            if(nums[middle] <= nums[end]){
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle;
                } 
                else{
                    end = middle;
                }
            }
            //nums[middle] > nums[start] > nums[end] || nums[end] > nums[middle] > nums[start]
            //if(nums[middle] >= nums[start]){
            else{
                if (target < nums[middle] && target >= nums[start]) {
                    end = middle;
                } 
                else {
                    start = middle;
                }
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
    */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
        
            if (nums[start] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } 
        
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
