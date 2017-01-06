public class Solution {
    /** Yunqiu Xu*/
    /**
     * put C[i] + D[j] in HashMap: O(n^2)
     * test A[i] + B[j]: O(n^2)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); //<sum, count>
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                if(map.containsKey(sum)){ //count++
                    map.put(sum, map.get(sum)+1);
                }
                else{
                    map.put(sum, 1);
                }
            }
        }
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int sum = -1 * (A[i] + B[j]);
                if(map.containsKey(sum)){ 
                    result += map.get(sum);
                }
            }
        }
        
        return result;
    }
}
