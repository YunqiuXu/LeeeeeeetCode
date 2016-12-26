public class Solution {
    /** Yunqiu Xu*/
    /** similar to LC136
    * i = 0,1,2,3...,n
    * nums[i] = 0,1,2,...k,k+2,...,n
    */
    /** public int missingNumber(int[] nums) {
        int result = 0;
        int i = 0;
        while(i < nums.length){
            result = result ^ i ^ nums[i];
            i++;
        }
        return result ^ i;
    }*/
    /** Another Easier Method*/
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++){
            sum += i - nums[i];
        }
        return sum;
    }
}
