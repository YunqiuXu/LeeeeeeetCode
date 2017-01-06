public class Solution {
    /** Yunqiu Xu*/
    /** 思路: 
     * 从右向左扫描
     * 若当前位小于9 --> 当前位+1直接返回
     * 否则当前位设为0, 继续循环
     * 若该循环到最后才跳出(溢出) --> 创建一个新数组1000000
     */
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return null;
        }
        
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newResult = new int[digits.length + 1];
        newResult[0] = 1;
        return newResult;
    }
}
