public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: single pointer*/
    public int removeElement(int[] nums, int val) {
        int pointer = 0; //pointer is the length of new array
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[pointer] = nums[i];
                pointer++;
            }
            //else --> we remove the element, the pointer does not change
        }
        return pointer;
    }
    /** Method 2: two pointers*/
    public int removeElement(int[] nums, int val){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] == val){ //出现重复用结尾的元素来填充
                nums[left] = nums[right];
                right--;
            }
            else{
                left++;
            }
        }
        return right+1;
    }
}
