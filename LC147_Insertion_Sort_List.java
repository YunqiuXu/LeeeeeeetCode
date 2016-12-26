/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode helper=new ListNode(0);
        ListNode prev=helper;
        ListNode curr=head;
        
        while(curr!=null){
            prev=helper;
            while(prev.next!=null && prev.next.val < curr.val) {
                prev=prev.next;
            }
            ListNode next=curr.next;
            curr.next=prev.next;
            prev.next=curr;
            curr=next;
        }
        
        return helper.next;
    }
}

/** Another method
public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null)
    {
        return head;
    }

    ListNode sortedHead = head, sortedTail = head;
    head = head.next;
    sortedHead.next = null;
    
    while (head != null)
    {
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        
        // new val is less than the head, just insert in the front
        if (temp.val <= sortedHead.val)
        {
            temp.next = sortedHead;
            sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
            sortedHead = temp;
        }
        // new val is greater than the tail, just insert at the back
        else if (temp.val >= sortedTail.val)
        {
            sortedTail.next = temp;
            sortedTail = sortedTail.next;
        }
        // new val is somewhere in the middle, we will have to find its proper
        // location.
        else
        {
            ListNode current = sortedHead;
            while (current.next != null && current.next.val < temp.val)
            {
                current = current.next;
            }
            
            temp.next = current.next;
            current.next = temp;
        }
    }
    
    return sortedHead;
}
*/

