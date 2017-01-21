public class Solution {
    /** Yunqiu Xu*/
    /** 按照提示来做:
     * 找到所有点的横坐标的最大值和最小值，二者的平均值为中间直线的横坐标
     * 然后遍历每个点，如果都能找到直线对称的另一个点，则返回true，反之返回false
     */
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0){
            return true;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //key为纵坐标, value为所有纵坐标相同的点的横坐标
        HashMap<Integer, HashSet<Integer>> hashmap = new HashMap<>();
        
        for (int i = 0; i < points.length; i++) {
            //横坐标最大值最小值
            max = Math.max(points[i][0], max);
            min = Math.min(points[i][0], min);
            if (!hashmap.containsKey(points[i][1])) {
                HashSet<Integer> hashset = new HashSet<>();
                hashset.add(points[i][0]);
                hashmap.put(points[i][1], hashset);
            } 
            else {
                hashmap.get(points[i][1]).add(points[i][0]);
            }
        }
        
        //若两点对称,这两点横坐标距离等于max+min
        for (int i = 0; i < points.length; i++) {
            if (!hashmap.containsKey(points[i][1]) || !hashmap.get(points[i][1]).contains(max + min - points[i][0])) {
                return false;
            }
        }
        
        return true;
    }
}
