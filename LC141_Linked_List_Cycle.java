/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 思路: 双指针, 若快慢指针可以相遇, 则证明有环
    */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
             //注意这里不可以用val,否则需要为fast.next!=null && fast.next.next!=null
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
