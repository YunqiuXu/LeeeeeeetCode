public class Solution {
    /** Yunqiu Xu*/
    //跟前面类似, 只不过每个元素最多只能用一次
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
        }
        
        if(index > candidates.length || target < 0){
            return;
        }
        
        int prev = -1;
        //和之前的区别, 每个只用一次
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] != prev) {
                path.add(candidates[i]);
                helper(candidates, target - candidates[i], path, i + 1, result); //LC039是i, 这里为i+1
                path.remove(path.size()-1);
                prev = candidates[i];
            }
        }
    }
}
