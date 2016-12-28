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
    /** Method:
    * L: L0->L1->L2->...->Ln --> L0->Ln->L1->Ln-1->L2->Ln-2
    * based on reverse + merge + findMiddle
    * 具体过程还要再理解!!
    */
    
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    //merge in turn
    private void merge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } 
            else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index ++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //reverse the middle-to-end, then merge
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;

        merge(head, tail);
    }
}
