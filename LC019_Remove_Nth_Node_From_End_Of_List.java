/**
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

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
    /** 思路: 双指针
     * 两个指针中间间隔为n-1
     * 快指针到达结尾时, 慢指针指向的就是需要被删除的结点的前一个结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0){
            return null;
        }
        
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        int count = 0;
        while(count < n){
            fast = fast.next;
            count++;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        //删除的是首结点
        if(slow.next == head){
            head = head.next;
            return head;
        }
        
        slow.next=slow.next.next;
        return head;
    }
    
    /** Jiuzhang's Method*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        
        //将被删除点的前一个结点初始化为dummy, 接下来的任务就是定位这一结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDelete = dummy;
        //head相当于慢指针, predelete相当于慢指针, 两个指针间隔n-1个结点
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        //不断向前直到head == null
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
