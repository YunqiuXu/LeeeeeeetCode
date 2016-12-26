public class Solution {
    /** Yunqiu Xu */
    /** 看了下答案, 还是搞不懂H因子怎么算 */
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(citations[mid] >= citations.length - mid){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        System.out.println("start = "+start);
        System.out.println("end = "+end);
        if(citations[start] >= citations.length - start){
            return citations.length - start;
        }
        if(citations[end] >= citations.length - end){
            return citations.length - end;
        }
        return 0;
    }
}
