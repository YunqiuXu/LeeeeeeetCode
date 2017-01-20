public class Solution {
    /** Yunqiu Xu*/
    /** E.G. num = "1432219", k = 3
     * 1, k = 3
     * 1-4, k = 3
     * 1-3, k = 2
     * 1-2, k = 1
     * 1-2-2, k = 1
     * 1-2-1, k = 0
     * output 1219
     */
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() <= k){
            return "0";
        }
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < num.length(); i++){
            //whenever a digit is smaller than the previous one, delete the previous one
            while(!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        //handle same number case like "1111"
        while(k > 0){
            stack.pop();
            k--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
