public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: stack*/
    public int calculate(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) || i == s.length() - 1){
                if(sign=='-'){
                    stack.push( -1 * num);
                }
                if(sign == '+'){
                    stack.push(num);
                }
                if(sign == '*'){
                    stack.push(stack.pop() * num);
                }
                if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int result = 0;
        for(int i : stack){
            result += i;
        }
        return result;
    }
    
    /** Method 2: O(1), do not need stack*/
    public int calculate(String s) {
        s = s.replace(" ","");
        long currRes = 0, prevNum = 0;
        // 拿出第一个数
        String firstNum = getNum(0, s);
        currRes = Long.parseLong(firstNum);
        prevNum = currRes;
        int i = firstNum.length();
        while(i < s.length()){
            char c = s.charAt(i);
            String numStr = getNum(i + 1, s);
            System.out.println(numStr);
            long n = Long.parseLong(numStr);
            if(c == '+'){
                currRes += n;
                prevNum = n;
            }
            if(c == '-'){
                currRes -= n;
                prevNum = -n;
            }
            if(c == '*'){
                // 上次的结果，减去上次的数，再加上上次的数乘以这次的数，就是这次的结果
                currRes = currRes - prevNum + prevNum * n;
                prevNum = prevNum * n;
            }
            if(c == '/'){
                // 上次的结果，减去上次的数，再加上上次的数除以这次的数，就是这次的结果
                currRes = currRes - prevNum + prevNum / n;
                prevNum = prevNum / n;
            }
            // 计算完后，跳过当前的运算符和数字
            i = i + numStr.length() + 1;
        }
        return (int)currRes;
    }
    
    private String getNum(int i, String s){
        StringBuilder num = new StringBuilder();
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            num.append(s.charAt(i));
            i++;
        }
        return num.toString();
    }
}
