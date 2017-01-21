public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 对于每个点构建一个HashMap, 计算其他所有点到该点的距离dist
     * 以dist为key存入HashMap, value为该dist出现次数n
     * 由于是排列问题, 对于每个n, 实际可用排列为n(n-1)
     */
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0){
            return 0;
        }
        int result = 0;
        
        for(int i = 0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j = 0; j < points.length; j++){
                if(i == j){
                    continue;
                }
                int dist = getDistance(points[i], points[j]);
                if(map.containsKey(dist)){
                    map.put(dist, map.get(dist) + 1);
                }
                else{
                    map.put(dist, 1);
                }
            }
            for(int value: map.values()){
                result += value * (value - 1);
            }
        }
        
        return result;
    }
    
    private int getDistance(int[] i, int[] j){
        return (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
    }
}
