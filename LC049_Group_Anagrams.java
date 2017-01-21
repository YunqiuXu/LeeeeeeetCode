public class Solution {
    /** Yunqiu Xu*/
    /** Method:
     * 首先将所有单词按字母进行排序
     * 以排序后的序列作为键值存入Map
     * Anagram会被放在同一列
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length == 0){
            return null;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            //单词按字母排序
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
            else{
                map.get(key).add(str);
            }
        }
        
        /** Can be omitted
        List<List<String>> result = new ArrayList<List<String>>();
        for(String key : map.keySet()){
            // 将列表按单词排序
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
        */
        
        return new ArrayList<List<String>>(map.values());
    }
}
