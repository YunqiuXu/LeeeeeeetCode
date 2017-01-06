public class Solution {
    /** Yunqiu Xu*/
    /** Similar to 3Sum and 3Sum Smaller*/
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];
        
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
                
                if(Math.abs(sum-target) < Math.abs(result-target)){
                    result = sum;
                }
            }
        }
        
        return result;
    }
}
