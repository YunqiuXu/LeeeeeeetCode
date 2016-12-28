/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /** Yunqiu Xu */
    /**Method 1: two pointers
     * 指针1指向当前可能存在重复的第一个结点A
     * 指针2初始化也为该结点
     * 指针2不断向后直到找到第一个与A不同的结点B
     * 将AB相连
     */
    /** public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while(pointer2 != null){
            if(pointer1.val == pointer2.val){
                pointer2 = pointer2.next;
            }
            else{
                pointer1.next = pointer2;
                pointer1 = pointer2;
                pointer2 = pointer2.next;
            }
        }
        pointer1.next = null;
        return head;
    }
    */
    /** Method 2: dummy node*/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                head.next = head.next.next;
            } 
            else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
