public class Solution {
    /** Yunqiu Xu*/
    /** Method 1*/
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0 ; i < chars.length; i++){
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char temp = stack.pop();
                if(temp == '(' && chars[i] == ')'){
                    continue;
                }
                else if(temp == '[' && chars[i] == ']'){
                    continue;
                }
                else if(temp == '{' && chars[i] == '}'){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    /** Method 2: similar solution from Jiuzhang*/
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
        if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
               if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                   stack.pop();
               } else {
                   return false;
               }
           }
       }
       return stack.isEmpty();
    }

    private boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }
}
