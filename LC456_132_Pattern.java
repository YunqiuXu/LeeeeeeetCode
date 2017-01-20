public class Solution {
    /** Yunqiu Xu*/
    /** Method: stack + variable
     * 变量mid为132中的2
     * 栈中存储大于mid的元素
     * 从后向前遍历, 对于某一元素curr:
     *      若curr < mid --> 1被找到, 返回true
     *      若curr > mid --> 按顺序将栈顶元素取出赋值给mid, 最后将curr压入栈
     * 始终保持栈中的3 > 变量2
     */
    public boolean find132pattern(int[] nums) {
       if(nums == null || nums.length < 3){
           return false;
       } 
       
       int mid = Integer.MIN_VALUE;
       Stack<Integer> stack = new Stack<Integer>();
       
       for(int i = nums.length - 1; i >= 0; i--){
           if(nums[i] < mid){
               return true;
           }
           else{
               while(!stack.isEmpty() && nums[i] > stack.peek()){
                   mid = stack.pop();
               }
               stack.push(nums[i]);
           }
       }
       
       return false;
    }
}
