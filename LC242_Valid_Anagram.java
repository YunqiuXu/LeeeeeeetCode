public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: sort*/
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
    
        Arrays.sort(sChar);
        Arrays.sort(tChar);
    
        return Arrays.equals(sChar, tChar);   
    }
    
    /** Method 2: hash table */
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        
        int[] check = new int[26];
        for(int i = 0; i < s.length(); i++){
            check[s.charAt(i) - 'a']++;
            check[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < check.length; i++){
            if(check[i] != 0){
                return false;
            }
        }
        return true;
    }
}
