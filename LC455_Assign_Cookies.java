public class Solution {
    /** Yunqiu Xu*/
    /** Greedy method
     * 首先，将孩子们按“对饼干尺寸要求最小”排序，将饼干按尺寸大小排序。
     * 然后，判断第一块饼干是否能满足第一个孩子，能就分给他，否则就换个稍微大点的，直到满足这个孩子。
     * 满足第一个孩子后，再对第二个、第三个以及后面的孩子重复上面一步，直到饼干分完为止。
     * 最后统计满足了多少个孩子，并返回结果
     */
    public int findContentChildren(int[] g, int[] s) {
        if( g == null || s == null || g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        
        int result = 0;
        for(int i = 0; i < s.length && result < g.length; i++){
            if(g[result] <= s[i]){
                result++;
            }
        }
        return result;
    }
}
