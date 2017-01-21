public class Solution {
    /** Yunqiu Xu*/
    //这道题提示太特么多了, 直接看的答案
    /** 埃拉托斯特尼筛法 Sieve of Eratosthenes
     * 如果一个数是另一个数的倍数，那这个数肯定不是素数
     * 可以建立一个素数数组，从2开始将素数的倍数都标注为不是素数
     * 第一轮将4、6、8等表为非素数
     * 然后遍历到3，发现3没有被标记为非素数，则将6、9、12等标记为非素数
     * 一直到N为止，再数一遍素数数组中有多少素数
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}
