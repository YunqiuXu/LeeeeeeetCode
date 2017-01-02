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
    /** Method 1*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        int newValue = 0;
        
        while(l1 != null || l2 != null || newValue != 0){
            if(l1 != null){
                newValue += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                newValue += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(newValue % 10);
            newValue = newValue / 10;
            curr = curr.next;
        }
        return newHead.next;
    }
    
    /** Method 2: Jiuzhang*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
            
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
