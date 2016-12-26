/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * 使用归并排序, 基于LC21
     * 双指针找到中点, 分割, 归并排序
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode curr=head;
        
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                curr.next=l2;
                l2=l2.next;
            }
            else{
                curr.next=l1;
                l1=l1.next;
            }
            curr=curr.next;
        }
        if(l1!=null){
            curr.next=l1;
        }
        if(l2!=null){
            curr.next=l2;
        }
        
        return head.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode prevSlow=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prevSlow=slow;
            slow=slow.next;
        }
        
        prevSlow.next=null;
        return mergeTwoLists(sortList(head),sortList(slow));
    }
}
