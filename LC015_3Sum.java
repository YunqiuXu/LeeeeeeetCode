public class Solution {
    /** Yunqiu Xu*/
    /** Similar to two-pointers
     * we sort the list first
     * then we try to find the result sets that satisfy b+c=-a
     * note that we need to skip duplicates
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // to skip duplicate numbers; e.g [0,0,0,0]
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) { // to skip duplicates
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) { // to skip duplicates
                        right--;
                    }
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
    
}
