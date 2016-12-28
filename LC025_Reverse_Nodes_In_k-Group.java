/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /** Yunqiu Xu */
    //看了答案, 还需再理解!!
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            //reverse the nodes from head to the kth next
            head = reverseNextK(head, k);
        }
        
        return dummy.next;
    }
    
    /** Similar to LC092*/
    // head->n1->..->nk --> head->nk->..->n1
    // return n1
    private ListNode reverseNextK(ListNode head, int k) {
        // check whether there is enough nodes to reverse
        ListNode next = head; // next is not null
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }
        
        // reverse
        ListNode n1 = head.next;
        ListNode prev = head;
        ListNode curt = n1;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        n1.next = curt;
        head.next = prev;
        return n1;
    }
    
}
