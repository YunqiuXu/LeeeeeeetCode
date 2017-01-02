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
    /** Method 1
    //reverse the linkedlist
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode nextHead = reverseList(head.next);
        
        head.next.next=head;
        head.next=null;
        return nextHead;
    }
    
    //check whether 2 linkedlist are same(the second one will be shorter)
    public boolean match(ListNode head1, ListNode head2){
        ListNode curr1=head1;
        ListNode curr2=head2;
        while(curr2!=null){
            if(curr1.val!=curr2.val){
                return false;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return true;
    }
     
    
     * 思路:
     * 1. 找到中点, 从中间断开
     * 2. 后半段反转
     * 3. 进行检查
    
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        
        //find the middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        //split the linked list [1,2,3,4,5]-->[1,2,3]+[4,5]
        ListNode newHead = slow.next;
        slow.next = null;
        
        //reverse the linkedlist starting from newHead
        ListNode reverseHead = reverseList(newHead);
        
        //check
        return match(head,reverseHead);
        
    }*/
    /** Method 2 : Jiuzhang */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        
        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p2 == null;
    }
    
    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}
