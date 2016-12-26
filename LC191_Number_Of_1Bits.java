public class Solution {
    // you need to treat n as an unsigned value
    /** Yunqiu Xu*/
    /** An example
     * n = 20 = 10100
     * n = n & n-1 = 10100 & 10011 = 10000, result = 1
     * n = n & n-1 = 10000 & 01111 = 0, result = 2
     * so the output should be 2
     */
    public int hammingWeight(int n) {
       if(n == 0){
           return 0;
       } 
       int result = 0;
       
       while(n != 0){
           n = n & n-1;
           result++;
       }
       return result;
    }
}
