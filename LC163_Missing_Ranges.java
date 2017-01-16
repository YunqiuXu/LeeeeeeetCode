public class Solution {
    /** Yunqiu Xu*/
    //日啊还要handle长整形, 受不鸟了
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long changeL = (long) lower;
        long changeU = (long) upper;
        List<String> result = new ArrayList<String>();
        
        if(nums == null || nums.length == 0){
            if(changeL == changeU){
                result.add(changeU + "");
            }
            else{
                result.add(changeL + "->" + changeU);
            }
            return result;
        }
        
        for(int curr : nums){
            long justBelow = (long) curr - 1;
            if(changeL == justBelow){
                result.add(changeL + "");
            }
            else if(changeL < justBelow){
                result.add(changeL + "->" + justBelow);
            }
            changeL = (long) curr + 1;
        }
        
        if(changeL == changeU){
            result.add(changeU + "");
        }
        else if(changeL < changeU){
            result.add(changeL + "->" + changeU);
        }
        return result;
    }
    
}
