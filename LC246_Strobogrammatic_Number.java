public class Solution {
    /** Yunqiu Xu*/
    /** 判定条件:
     * 6对应9
     * 9对应6
     * 1对应1
     * 8对应8
     * 0对应0
     * 除了中点外, 其余数字不会出现
     */
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return true;
        }
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (!map.containsKey(num.charAt(l))){
                return false;
            }
            if (map.get(num.charAt(l)) != num.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
}
