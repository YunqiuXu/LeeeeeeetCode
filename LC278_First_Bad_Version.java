/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    /** Yunqiu Xu*/
    public int firstBadVersion(int n) {
        if(n==0){
            return 0;
        }
        int start = 1;
        int end = n;
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if(isBadVersion(middle)){
                end = middle;
            }
            else{
                start = middle;
            }
        }
        if(isBadVersion(start)){
            return start;
        }
        if(isBadVersion(end)){
            return end;
        }
        return 0;
    }
}
