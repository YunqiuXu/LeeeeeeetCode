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
    /** Question:
    * rotate the list to the right by k places
    * 1->2->3->4->5->NULL k = 2, return 4->5->1->2->3->NULL.
    * you need to know the kth last and k+1th last
    */
    
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        //如果多跑了几圈等价于跑了一圈
        int length = getLength(head);
        n = n % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        
        //init: head = 2, tail = dummy 
        //head = 3, tail = 1
        //head = 4, tail = 2
        //head = 5, tail = 3
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        
        //head.next = 1
        //dummy.next = 4
        //tail.next = 0
        //return 4-5-1-2-3
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
}
