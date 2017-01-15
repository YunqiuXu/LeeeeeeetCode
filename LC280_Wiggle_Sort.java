public class Solution {
    /** Yunqiu Xu*/
    /** Method:
     * If i is odd, then nums[i] >= nums[i - 1];
     * If i is even, then nums[i] <= nums[i - 1].
     */
    /** An example: [3, 5, 2, 1, 6, 4]
     * i = 0 --> [3, 5, 2, 1, 6, 4]
     * i = 1 --> [3, 5, 2, 1, 6, 4]
     * i = 2 --> [3, 5, 2, 1, 6, 4]
     * i = 3 --> [3, 5, 1, 2, 6, 4]
     * i = 4 --> [3, 5, 1, 6, 2, 4]
     * i = 5 --> [3, 5, 1, 6, 2, 4]
     */
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        for(int i = 0;i < nums.length; i++){
            if(i % 2 == 1){
               if(nums[i - 1] > nums[i]){
                   swap(nums, i);
               } 
            }
            else if(i != 0 && nums[i - 1] < nums[i]){
                swap(nums, i);
            }
        }
    }
    
    public void swap(int[] nums, int i){
        int tmp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = tmp;
    }
}
