public class Solution {
    /** Yunqiu Xu*/
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int currMax = 0;
        int currCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                currCount++;
            }
            else{
                currMax = Math.max(currCount, currMax);
                currCount=0;
            }
        }
        
        return Math.max(currCount, currMax);
    }
}
