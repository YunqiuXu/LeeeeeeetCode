public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 对于每个高度, 看这个高度的矩形最宽能有多宽(向左向右遍历，直到高度小于该bar), 计算该区域的面积
     * 
     * 实现:
     * 栈中存储的元素为某一高度的bar第一次出现在直方图中的位置i
     * 如果当前高度h[i]小于栈顶高度h[top]，
     * pop出top并计算以h[top]为高度的矩形面积, 对结果进行更新
     * 最后将i加入栈
     * 
     * 宽度计算: 从当前高度的位置i的前一个i-1开始, 一直到前一个高度第一次出现的位置
     * 宽度 = 右边界index - 左边界index = 当前index - 1 - 前一高度第一次出现位置
     * e.g. for height = 5, width = 4 - 1 - 1 = 2
     * 右边界 -> 当前索引 - 1
     * 左边界 -> 栈顶位置
     */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i <= heights.length; i++){
            //curr: 当前bar的高度, 若已经到了最后一个bar, 则将curr设为-1
            int curr = (i == heights.length) ? -1 : heights[i];
            //curr高度低于前一个高度h -> 将h取出 -> 计算以h为高度的矩形面积 -> 比较并更新结果
            while (!stack.isEmpty() && curr <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                result = Math.max(result, h * w);
            }
            //最后将新的高度加入栈, 代表这个高度第一次出现在直方图中的位置
            stack.push(i);
        }
        
        return result;
    }
    
    /** Another similar method */
     public int largestRectangleArea(int[] height) {
        int max_area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < height.length; i++) {
            if (stack.empty()) {
                stack.push(i);
            } 
            else {
                while (!stack.empty() && height[i] < height[stack.peek()]) {
                    int last_height = height[stack.pop()];
                    if (!stack.empty()) {
                        max_area = Math.max(max_area, (i - 1 - stack.peek()) * last_height);
                    } 
                    else {
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
    }
    
}
