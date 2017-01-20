public class Solution {
    /** Yunqiu Xu*/
    /** 统计词频, 奇数个字符最多出现一次, 否则为false*/
    /** Method 1: hashMap*/
    public boolean canPermutePalindrome(String s) {
        if(s.length() <= 1){
            return true;
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
        int oddCount = 0;
        for(Character c: map.keySet()){
            if(map.get(c) % 2 == 1){
                oddCount++;
            }
            if(oddCount > 1){
                return false;
            }
        }
        return true;
    }
    
    /** Method 2: HashSet*/
    public boolean canPermutePalindrome(String s) {
        if(s.length() <= 1){
            return true;
        }
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(set.contains(curr)){
                set.remove(curr);
            }
            else{
                set.add(curr);
            }
        }
        return set.size() <= 1;
    }
}
