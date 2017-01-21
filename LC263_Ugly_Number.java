public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 用2/3/5一个个除直到最后
     * 如果就剩下1则true*/
    public boolean isUgly(int num) {
        for(int i = 2; i < 6 && num > 0; i++){
            while(num % i == 0){
                num /= i;
            }
        }
        return num == 1;
    }
}
