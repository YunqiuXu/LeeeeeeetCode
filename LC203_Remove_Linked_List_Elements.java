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
    public ListNode removeElements(ListNode head, int val) {
        //如果第一个就匹配了, 一直删除直到找到第一个非匹配
        while(head!=null && head.val==val){
            head=head.next;
        }
        
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }
    
    /** Jiuzhang Dummy Node*/
    //省略了判断首结点的过程
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}
