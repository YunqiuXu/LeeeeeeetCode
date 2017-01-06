public class Solution {
    /** Yunqiu Xu*/
    //注意初始化指针时需要为长整形, 因为整形最小值可能包含在数组内[-2147483648, 1, 2]
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }
            else if(nums[i] > second && nums[i] < first){
                third = second;
                second = nums[i];
            }
            else if(nums[i] > third && nums[i] < second){
                third = nums[i];
            }
        }
        
        return third == Long.MIN_VALUE ? (int)first : (int)third;
    }
}
