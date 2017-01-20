public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: hashMap*/
    public int longestPalindrome(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(map.get(curr) == null){
                map.put(curr, 1);
            }
            else{
                map.put(curr, map.get(curr) + 1);
            }
        }
        int maxOdd = 0;
        int oddCount = 0;
        int maxEven = 0;
        for(Character c: map.keySet()){
            int count = map.get(c);
            if(count % 2 == 1){
                oddCount++;
                maxOdd += count - 1;
            }
            else{
                maxEven += count;
            }
        }
        return oddCount == 0 ? maxEven : maxEven + maxOdd + 1;
    }
    /** Method 2: hashSet*/
    public int longestPalindrome(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(set.contains(curr)){
                set.remove(curr);
                count++;
            }
            else{
                set.add(curr);
            }
        }
        return  set.size() == 0 ? count * 2 : count * 2 + 1;
    }
}
