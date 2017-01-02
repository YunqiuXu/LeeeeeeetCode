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
    /** Yunqiu Xu*/
    /**
     * 思路: 双指针, 若快慢指针可以相遇, 则证明有环
    */
    public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
    }
}
