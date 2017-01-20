public class Solution {
    /** Yunqiu Xu*/
    //Brute force
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        
        int n = haystack.length();
        int m = needle.length();
        
        for(int i = 0; i < n - m + 1; i++){
            int j = 0;
            while(j < m && haystack.charAt(i + j) == needle.charAt(j)){
                //这里跳出循环要么是完全匹配, 要么就是不匹配
                j++; 
            }
            if(j == m){
                //完全匹配->给出output,结束循环
                return i;
            } 
        }
        return -1;
    }
}
