public class Solution {
    /** Yunqiu Xu*/
    //还需再理解,或者看下别人的做法, 这个题比较新做的人少
    /** Flip at most one 0
     * use two pointers
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int zero = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){                                           
                zero++;
            }
            while (zero > 1){
                if (nums[j] == 0){
                    zero--;                      
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
        }                                                               
        return max;             
    }
}
