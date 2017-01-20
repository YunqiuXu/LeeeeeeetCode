public class Solution {
    /** Yunqiu Xu*/
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            if(!"+-*/".contains(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int digit1 = stack.pop();
                int digit2 = stack.pop();
                stack.push(calculate(digit1, digit2, tokens[i]));
            }
        }
        return stack.pop();
    }
    
    private int calculate(int digit1, int digit2, String operator){
        if(operator.equals("+")){
            return digit1 + digit2;
        }
        else if(operator.equals("-")){
            return digit2 - digit1;
        }
        else if(operator.equals("*")){
            return digit2 * digit1;
        }
        else{
            return digit2 / digit1;
        }
    }
}
