public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 对于每个高度
     * 看这个高度的矩形最宽能有多宽(向左向右遍历，直到高度小于该bar)
     * 计算该区域的面积
     * 宽度 = 右边界index - 左边界index - 1, e.g. for height = 5, width = 4 - 1 - 1 = 2
     * 
     * 
     * 从左到右遍历所有bar，并将其push到一个stack中，
     * 如果当前bar的高度小于栈顶bar，
     * pop出栈顶的bar，同时以该bar计算矩形面积
     * 右边界 -> 当前索引
     * 左边界 -> 栈顶位置
     */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i <= heights.length; i++){
            int curr = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && curr <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, h * w);
            }
            stack.push(i);
        }
        
        return result;
    }
    
    /** Another similar method:
     public int largestRectangleArea(int[] height) {
        int max_area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < height.length; i++) {
            if (stack.empty()) {
                stack.push(i);
            } else {
                while (!stack.empty() && height[i] < height[stack.peek()]) {
                    int last_height = height[stack.pop()];
                    if (!stack.empty()) {
                        max_area = Math.max(max_area, (i - 1 - stack.peek()) * last_height);
                    } else {
                        max_area = Math.max(max_area, i * last_height);
                    }
                }
                stack.push(i);
            }
        }
        
        while (!stack.empty()) {
            int last_height = height[stack.pop()];
            if (!stack.empty()) {
                max_area = Math.max(max_area, (height.length - 1 - stack.peek()) * last_height);
            } else {
                max_area = Math.max(max_area, height.length * last_height);
            }
        }
        
        return max_area;
    }*/
    
}
