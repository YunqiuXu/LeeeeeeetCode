public class Solution {
    //看了答案, 这题比较tricky, 不大理解!!
    /** Yunqiu Xu*/
    /** 思路
     * 遍历数组nums，记当前元素为n，令nums[abs(n) - 1] = -abs(nums[abs(n) - 1])
     * 第二次遍历, 正数元素index+1即为缺失数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        for(int i = 0; i < nums.length; i++){
            int location = Math.abs(nums[i]) - 1;
            if(nums[location] > 0){
                nums[location] = -nums[location];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
