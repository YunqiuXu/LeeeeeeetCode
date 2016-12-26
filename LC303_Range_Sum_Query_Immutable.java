public class NumArray {
    
    /** Yunqiu Xu*/
    //用了一个数组sums来储存dp状态, sums[i] --> nums[0] + nums[1] + ... + nums[i]
    int[] sums;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        sums = new int[nums.length];
        sums[0] = nums[0];
            
        for(int i = 1; i < nums.length; i++){
            sums[i] = sums[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return sums[j];
        }
        return sums[j] - sums[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
