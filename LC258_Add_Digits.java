public class Solution {
    /** Yunqiu Xu*/
    //数学问题: 每9个一循环，所有大于9的数的树根都是对9取余
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
