public class Solution {
    /** Yunqiu Xu*/
    /** Method: HashMap*/
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //<element, count>
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > nums.length/3){
                result.add(nums[i]);
                map.put(nums[i], Integer.MIN_VALUE); //this element will never be added in result again
            }
        }
        
        return result;
    }
}
