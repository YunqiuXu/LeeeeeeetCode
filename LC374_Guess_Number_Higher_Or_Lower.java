/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /** Yunqiu Xu*/
    public int guessNumber(int n) {
        int i = 1;
        int j = n;
        while(i+1 < j){
            int mid = i + (j-i) / 2;
            if(guess(mid) == 0){
                j = mid;
            }
            else if(guess(mid) == 1){ //your guess is larger than target
                i = mid;
            }
            else{ //your guess is smaller than target
                j = mid;
            }
        }
        if(guess(i) == 0){
            return i;
        }
        if(guess(j) == 0){
            return j;
        }
        return -1;
    }
}
