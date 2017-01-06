public class Solution {
    /** Yunqiu Xu*/
    //x轴上在1,2,...,n点上有许多垂直的线段，长度依次是a1, a2, ..., an
    //找出两条线段，使他们和x抽围成的面积最大。面积公式是 Min(ai, aj) X |j - i|
    //如果我面试挂了, 想必也是因为阅读理解能力太差
    //日!!
    public int maxArea(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int currMax = Integer.MIN_VALUE;
        
        while(left < right){
            currMax = Math.max(currMax, Math.min(height[left], height[right])*(right - left));
            if(height[left] < height[right]){
                //短板在左改变左
                left++;
            }
            else{
                //短板在右改变右
                right--;
            }
        }
        return currMax;
    }
}
