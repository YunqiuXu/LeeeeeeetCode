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
    /** Recursive version
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode nextHead = reverseList(head.next);
        
        head.next.next=head;
        head.next=null;
        return nextHead;
    }*/
    /** Iterative version: recommend */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            //head is the curr node to be changed
            //prev is the node ahead of curr
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
