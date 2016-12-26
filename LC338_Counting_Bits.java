public class Solution {
    /** Yunqiu Xu*/
    //关键公式还需继续理解
    /** DP
     * state: f[i] --> the result for i
     * function:
     *      f[i] = f[i >> 1] + (i & 1)
     * init: f[0] = 0
     * answer: f
     */
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++){
            f[i] = f[i >> 1] + (i & 1);
        } 
        return f; 
    }
}
