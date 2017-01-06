public class Solution {
    /** Yunqiu Xu*/
    //类似3Sum, 多嵌套了一层循环
    //find c + d = -(a + b)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // to skip duplicate numbers
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue; // to skip duplicate numbers
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
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
                    else if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
