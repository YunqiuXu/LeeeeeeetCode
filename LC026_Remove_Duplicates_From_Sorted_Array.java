public class Solution {
    /** Yunqiu Xu*/
    //similar to LC083 Remove Duplicates from Sorted List
    //similar to LC027 Remove Element
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int pointer = 1; //the index of new array (length - 1)
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}
