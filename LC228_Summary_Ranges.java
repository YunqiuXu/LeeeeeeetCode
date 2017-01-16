public class Solution {
    /** Yunqiu Xu*/
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            while( i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1){
                i++;
            }
            if(curr != nums[i]){
                result.add(curr + "->" + nums[i]);
            }
            else{
                result.add(curr + "");
            }
        }
        
        return result;
    }
}
