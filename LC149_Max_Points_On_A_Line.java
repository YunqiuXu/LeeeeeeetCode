/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /** Yunqiu Xu*/
    //思路懂了但还是看了答案, 之后可以自己再试试看
    /** 思路:
     * 若(A,B)斜率与(B,C)斜率相同, 则共线
     * 取定一个点(xk,yk), 遍历所有节点(xi, yi), 然后统计斜率相同的点数，并求取最大值
     */
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        //key: slope
        HashMap<Double, Integer> map=new HashMap<Double, Integer>();
        int max = 1;
        
        for(int i = 0 ; i < points.length; i++) {
            //换点时需要重新计算斜率
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);

            int dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                double key = getSlope(points[i], points[j]);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } 
                else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }
    
    private double getSlope(Point i, Point j){
        //注意这里要做下显式转换
        return (i.x == j.x) ? Integer.MAX_VALUE : 0.0 + (double)(j.y - i.y) / (double)(j.x - i.x);
    }
    
}
