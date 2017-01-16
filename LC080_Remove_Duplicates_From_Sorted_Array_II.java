public class Solution {
    /** Yunqiu Xu*/
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int pointer = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                if(count < 2){ //count<2依旧可以加入新数组
                    nums[pointer++] = nums[i];
                }
                count++;
            }
            else{
                count = 1;
                nums[pointer++] = nums[i];
            }
        }
        
        return pointer;
    }
}

