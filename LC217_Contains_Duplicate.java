public class Solution {
    /** Yunqiu Xu*/
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); //<value, count>
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], 0);
        }
        return false;
    }
}
