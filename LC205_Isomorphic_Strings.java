public class Solution {
    /** Yunqiu Xu*/
    //还需继续理解!
    /** Method: Two strings are isomorphic if the characters in s can be replaced to get t.
     * 使用哈希表维护映射关系
     */
     
    /** Method 1*/
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1){
            return true;
        }
        int[] sToT = new int[256];
        int[] tToS = new int[256];
        char[] sValue = s.toCharArray();
        char[] tValue = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sToT[sValue[i]] == 0 && tToS[tValue[i]] == 0) {
                sToT[sValue[i]] = tValue[i];
                tToS[tValue[i]] = sValue[i];
            } else if (sToT[sValue[i]] != tValue[i] || tToS[tValue[i]] != sValue[i]) {
                return false;
            } 
        }
        return true;
    } 
     
    /** Method 2 */
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1){
            return true;
        }
        
        Map<Character, Integer> m1 = new HashMap<Character, Integer>();
        Map<Character, Integer> m2 = new HashMap<Character, Integer>();
    
        for(Integer i = 0; i < s.length(); i++) {
            if(m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}
