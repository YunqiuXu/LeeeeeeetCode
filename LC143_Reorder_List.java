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
    
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } 
            else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        //leftDummy-0-1-2-3(left)
        //rightDummy-7-8-9(right)
        //leftDummy-0-1-2-3-7-8-9-null
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}
