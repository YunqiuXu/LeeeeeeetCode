/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /** recursive version*/
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode nextHead = reverseList(head.next);
        
        head.next.next=head;
        head.next=null;
        return nextHead;
    }
    /** iterative version */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        
        while(q!=null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        head=p;
        return head;
    }
}
