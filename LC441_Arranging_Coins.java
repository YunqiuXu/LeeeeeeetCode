public class Solution {
    /** Yunqiu Xu*/
    public int arrangeCoins(int n) {
        if(n <= 1){
            return n;
        }
        
        int currCount = 0;
        int currSum = n;
        while(currSum >= 0){
            currCount++;
            currSum = currSum - currCount;
        }
        return currCount - 1;
    }
}
