public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: HashMap
     * O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //<element , index>
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    /** Method 2: Two Pointers
     * sort the array first
     * then use two pointers
     * O(nlogn)
     */
    //注意该题双指针比较麻烦，找到后还需要返回排序前的下标
    
}
