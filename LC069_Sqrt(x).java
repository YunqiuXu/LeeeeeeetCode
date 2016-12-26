public class Solution {
    /** Yunqiu Xu*/
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        while(start + 1 < end){
            long middle = start + (end - start) / 2;
            long square = middle * middle;
            if(square == x){
                return (int) middle;
            }
            else if(square < x){
                start = middle;
            }
            else{
                end = middle;
            }
        }
        long startS = start * start;
        long endS = end * end;
        if(startS == x){
            return (int) start;
        }
        if(endS == x){
            return (int) end;
        }
        if(startS < x){
            return (int) start;
        }
        if(endS < x){
            return (int) end;
        }
        return -1;
        
    }
}
