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
     * 思路: 
     * 有环情况下，快慢指针相遇时，慢指针位置不变，
     * 将快指针置回表头，步长改为每次移1，
     * 快慢指针同时开始移动，再次相遇处即为环的入口
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode fast2=head;
                while(fast2!=slow){
                    fast2=fast2.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
