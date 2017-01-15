public class Solution {
    /** Yunqiu Xu*/
    //这次是对组合的元素数量有限制, 可以基于40. Combination Sum II进行改造
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        helper(n, path, 1, result, k);

        return result;
    }
    
    //[1,2,3,4,5,6,7,8,9]
    private void helper(int target, List<Integer> path, int index, List<List<Integer>> result, int k) {
        if (target == 0 && path.size() == k){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        //int prev = -1;
        for (int i = index; i < 10; i++) {
            path.add(i);
            helper(target - i, path, i + 1, result, k);
            path.remove(path.size()-1);
        }
    }
}
