public class Solution {
    /** Yunqiu Xu*/
    /** 思路: 可以参考下快排的partition*/
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        
        while(i <= blue){
            if(nums[i] == 0){ //red
                swap(nums, red, i);
                red++;
                i++;
            }
            else if(nums[i] == 1){ //white
                i++;
            }
            else{ //blue
                swap(nums, blue, i);
                blue--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}

