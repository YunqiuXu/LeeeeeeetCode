public class Solution {
    /** Yunqiu Xu*/
    public int trap(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int leftheight = height[left]; //左边最大高度
        int rightheight = height[right]; //右边最大高度
        int result = 0;
        
        while(left < right) {
            if(leftheight < rightheight) { //左边是短板
                left++;
                if(leftheight > height[left]) { //新的左边比原来的左边低 --> 可以存住
                    result += (leftheight - height[left]);
                } 
                else { //新的左边更高 --> 存不住水
                    leftheight = height[left];
                }
            }
            else {
                //右边是短板
                right--;
                if(rightheight > height[right]) {
                    result += (rightheight - height[right]);
                } 
                else {
                    rightheight = height[right];
                }
            }
        }
        return result;
    }
}
