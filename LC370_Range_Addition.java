public class Solution {
    /** Yunqiu Xu*/
    /** 思路:
     * 对于操作 [startIndex, endIndex, inc] 
     * 令result[startIndex] += inc
     * 令result[endIndex+1] += -inc
     * 所有操作完成后进行累加即可得到结果
     * [1, 3, 2] --> [0, 2, 0, 0, -2]
     * [2, 4, 3] --> [0, 2, 3, 0, -2](-3 is out of bound)
     * [0, 2, -2]--> [-2, 2, 3, 2, -2]
     * sum --> [-2, 0, 3, 5, 3]
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] results = new int[length];
        if (length < 0 || updates == null || updates.length == 0) {
            return results;
        }
        
        for(int[] update : updates) {
            results[update[0]] += update[2];  
            if (update[1] + 1 < length){
                results[update[1] + 1] -= update[2]; 
            }
        }
        
        int value = 0; 
        for(int i = 0; i < length; i++) {  
            value += results[i];  
            results[i] = value;  
        }  
        return results; 
    }
}
