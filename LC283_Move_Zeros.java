public class Solution {
    /** Yunqiu Xu*/
    /** Method 1:
     * put all the non-zero elements at the head
     * then add zero at behind
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int pointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        for(int i = pointer; i < nums.length; i++){
            nums[i] = 0;
        }
    }
    /** Method 2: maybe faster */
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = temp;
                pointer++;
            }
        }
    }
}
