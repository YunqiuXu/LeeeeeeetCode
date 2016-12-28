/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /** Yunqiu Xu*/
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                //there are duplicate elements
                //remove all the duplicates after "head"
                //until head.next == null || head.next.val != val
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }            
            } 
            else {
                head = head.next;
            }
        }
        
        //no matter what changes happened, the return value does not change
        return dummy.next;
    }
}
