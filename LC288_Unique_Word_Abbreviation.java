/** Yunqiu Xu*/
/** 题意: 判断单词缩写是不是独特的
 * 单词缩写为首字母+中间长度+尾字母
 * E.G. deer --> d2r, door --> d2r, not unique
 */
public class ValidWordAbbr {
    private Map<String, String> map; //<abbreviation, original word>
    public ValidWordAbbr(String[] dictionary) {
        //注意map里可能存在本身缩写就相同的
        //若字典中多个不同单词是这个缩写, 则将value设为"",这样无论如何都会返回false
        map = new HashMap<String, String>();
        for(String word: dictionary){
            String key = getKey(word);
            if(map.containsKey(key) && !word.equals(map.get(key))){
                map.put(key,"");
            }
            else{
                map.put(key, word);
            }
        }
    }
    
    //false: 缩写在字典中存在, 但是单词在字典中不存在, 或者字典中多个单词是这个缩写
    public boolean isUnique(String word) {
        String key = getKey(word);
        if(map.containsKey(key) && !word.equals(map.get(key))){
            return false;
        }
        return true;
    }
    
    private String getKey(String word){
        return word.length() <= 2 ? word : word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
