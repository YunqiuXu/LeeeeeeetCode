public class Solution {
    /** Yunqiu Xu*/
    /** 注意需要用长整形, 不然容易超限*/
    public boolean isPerfectSquare(int num) {
        if(num == 0){
            return true;
        }
        long start = 0;
        long end = num;
        while(start + 1 < end){
            long middle = start + (end - start) / 2;
            long square = middle * middle;
            
            if(square == num){
                return true;
            }
            else if(square < num){
                start = middle;
            }
            else{
                end = middle;
            }
        }
        long startS = start * start;
        long endS = end * end;
        if(startS == num){
            return true;
        }
        if(endS == num){
            return true;
        }
        return false;
    }
}
