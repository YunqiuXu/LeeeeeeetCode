public class Solution {
    /** Yunqiu Xu*/
    /** Greedy Method
     * 若总的cost > gas,无论怎么搞都没法绕圈圈的
     * 假定从i出发, 当我们发现到达k站点邮箱见底儿后，i 到 k 这些站点都不用作为出发点来试验了，肯定不满足条件，只需要从k+1站点尝试即可
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
       if(gas == null || cost == null || gas.length == 0 || cost.length == 0){
           return -1;
       } 
       
       int start = 0;
       int sum = 0;
       int total = 0;
       
       for(int i = 0; i < gas.length; i++){
           total += (gas[i] - cost[i]);
           if(sum < 0){ //跳过前面所有的点
               sum = gas[i] - cost[i];
               start = i;
           }
           else{
               sum += (gas[i] - cost[i]);
           }
       }
       
       return total < 0 ? -1 : start;
       
    }
}