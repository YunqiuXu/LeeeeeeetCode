public class Solution {
    /** Yunqiu Xu*/
    //使用内建方法
    public String reverseWords(String s) {
        String[] after = s.trim().split(" +");
        Collections.reverse(Arrays.asList(after));
        return String.join(" ", after);
    }
}
