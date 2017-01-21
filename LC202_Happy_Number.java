public class Solution {
    /** Yunqiu Xu*/
    /** Method: HashSet
     * use a hash set to store the number n in each sum
     * when sum == 1 or n can not be added to set, return result
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        
        while(set.add(n)){
            int currSum = 0;
            while(n > 0){
                int remain = n % 10;
                currSum += remain * remain;
                n /= 10;
            }
            if(currSum == 1){
                return true;
            }
            n = currSum;
        }
        
        return false;
    }
}
