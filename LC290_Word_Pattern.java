public class Solution {
    /** Yunqiu Xu*/
    /** Method:
     * 建立模式字符串中每个字符和单词字符串每个单词之间的映射
     */
    public boolean wordPattern(String pattern, String str) {
        String[] words= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        
        if(words.length != pattern.length()){
            return false;
        }
        
        for(int i=0; i < words.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i])){
                    return false;
                }
            }
            else{
                if(map.containsValue(words[i])){
                    return false;
                }
                map.put(c, words[i]);
            }    
        }
        return true;
    }
}
