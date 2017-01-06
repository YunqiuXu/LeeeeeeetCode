public class Solution {
    //比较tricky 不大理解
    /** Yunqiu Xu*/
    /** Similar to LC142 Linked List Cycle II
     * The fast one goes forward two steps each time, while the slow one goes only step each time. 
     * Next we just need to find the entry point.
     */
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int slow = nums[0];
        int fast = nums[slow];
        
        //check the cycle
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        //find the entry
        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return slow;
    }
}
