public class Solution {
    /** Yunqiu Xu*/
    /** Similar to 3Sum
     * Sort the array then use two pointers
     */
     
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum < target){
                    /** optimisation:
                     * if sum < target
                     * the sum with smaller nums[right] will also smaller than target
                     */
                    result += right - left;
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}
