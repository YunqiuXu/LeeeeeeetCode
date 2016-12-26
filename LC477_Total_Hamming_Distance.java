public class Solution {
    /** Yunqiu Xu*/
    //based on LC191, LC461
    //看了答案, 还需继续理解!!
    /** Method 1: similar to insertion sort, but exceed time limit !!
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        if(nums == null || nums.length == 0){
            return sum;
        }
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            int j = i - 1;
            while(j >= 0){
                sum += hammingDistance(curr, nums[j]);
                j--;
            }
        }
        return sum;
    }
    
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int result = 0;
        while(n != 0){
           n = n & n-1;
           result++;
        }
        return result;
    }
    */
    /** Method 2*/
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitmask = 1 << i;
            int onebits = 0;
            for (int num : nums) {
                if ((num & bitmask) != 0) {
                    onebits++;
                }
            }
            result += onebits * (nums.length - onebits);
        }
        return result;
    }
}
