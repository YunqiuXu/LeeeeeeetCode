public class Solution {
    /** Yunqiu Xu*/
    /** 思路: 这都是什么脑子啊...
     * 字符串的每个字母和首字符的相对距离都是相等的
     * E.G. abc & efg : abc = [0,1,2] , efg = [0,1,2]
     * E.G. az & ba: az = [0,-1], ba = [0,-1]
     */
    public List<List<String>> groupStrings(String[] strings) {
        if(strings == null || strings.length == 0){
            return new ArrayList<List<String>>();
        }
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        Arrays.sort(strings);
        for(String str : strings) {
            String key = "";
            for(int i = 1; i < str.length(); i++){
                key += ((str.charAt(i) - str.charAt(i - 1) + 26) % 26) + ",";
            }
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}
