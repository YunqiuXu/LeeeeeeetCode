public class Solution {
    /** Yunqiu Xu*/
    //回溯算法我还是不大理解
    /** 排序后使用回溯算法 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, path, 0, result);

        return result;
    }
    
    private void helper(int[] candidates, int target, List<Integer> path, int index, List<List<Integer>> result) {
        //target == 0 --> 将之前的路径都塞进结果
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            //因为是有序数组, 后边的都不需要再检查了
            if (candidates[i] > target) {
                break;
            }

            if (prev != -1 && prev == candidates[i]) {
                continue;
            }

            path.add(candidates[i]);
            helper(candidates, target - candidates[i], path, i, result);
            path.remove(path.size() - 1);

            prev = candidates[i];
        }
    }
}
