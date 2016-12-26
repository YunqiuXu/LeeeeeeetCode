/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead=new ListNode(0);
        ListNode curr=newHead;
        int newValue=0;
        
        while(l1!=null || l2!=null||newValue!=0){
            if(l1!=null){
                newValue+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                newValue+=l2.val;
                l2=l2.next;
            }
            curr.next=new ListNode(newValue%10);
            newValue=newValue/10;
            curr=curr.next;
        }
        return newHead.next;
    }
}
