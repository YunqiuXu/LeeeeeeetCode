public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: AC by DP*/
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        int start = 0;
        Stack<Integer> stack=new Stack<Integer>();
        int[] a = new int[s.length()];
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(c[i] == '('){
                stack.push(i);
            } 
            else if(!stack.empty()){
                //当前为')'且栈中还有未被匹配的'('
                start = stack.pop();
                a[i] = i - start + 1;
                if(start > 1){
                    a[i] += a[start-1];
                }
                maxLen = Math.max(maxLen, a[i]);
            }
        }
        return maxLen;
    }
    /** Method 2: Stack, but I face time limit */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        
        int maxLen = 0;
        int last = -1; //最后一个无法匹配的'('的位置 --> 所有无法匹配的')'”的index其实都是各个group的分界点
        Stack<Integer> lefts = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } 
            else {
                if (lefts.isEmpty()) {
                    // this ')' can not be matched
                    last = i;
                } 
                else{
                    lefts.pop(); // find a matching pair
                    if (lefts.isEmpty()) {
                        //()()
                        //当前刚好完全匹配, 计算该group的长度i-last并对结果进行更新
                        maxLen = Math.max(maxLen, i-last);
                    } 
                    else {
                        //(()..
                        //栈内还有‘(', 通过查询栈中下一个即将被匹配的"("的index来更新maxLen
                        maxLen = Math.max(maxLen, i-lefts.peek());
                    }
                }
            }
        }
        
        return maxLen;
    }
}
