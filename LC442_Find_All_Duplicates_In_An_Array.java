public class Solution {
    /** Yunqiu Xu*/
    /** Method: similar to LC448
     * when find a number i, flip the number at position i-1 to negative. 
     * if the number at position i-1 is already negative, i is the number that occurs twice.
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        for(int i = 0; i < nums.length; i++){
            int location = Math.abs(nums[i])-1;
            if(nums[location] > 0){
                nums[location] = -nums[location];
                
            }
            else{
                result.add(Math.abs(nums[i]));
            }
        }
        
        return result;
    }
}
