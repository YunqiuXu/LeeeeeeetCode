/**
* "()" and "()[]{}" are all valid but "(]" and "([)]" are not
*/

public class Solution {
    /** Yunqiu Xu
     * use stack
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{'){
                stack.push(chars[i]);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char temp=stack.pop();
                if(temp=='(' && chars[i]==')'){
                    continue;
                }
                else if(temp=='[' && chars[i]==']'){
                    continue;
                }
                else if(temp=='{' && chars[i]=='}'){
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
}
