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
    /** Method 1: same with LC025
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            //reverse the nodes from head to the kth next
            head = reverseNextK(head, 2);
        }
        
        return dummy.next;
    }
    
    private ListNode reverseNextK(ListNode head, int k) {
        // check whether there is enough nodes to reverse
        ListNode next = head; // next is not null
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }
        // reverse
        ListNode n1 = head.next;
        ListNode prev = head;
        ListNode curt = n1;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        n1.next = curt;
        head.next = prev;
        return n1;
    }*/
    /** Method 2: easier method*/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head.next;
        head.next = swapPairs(head.next.next);
        curr.next = head;
        return curr;
    }
    
    /** Method 3: Jiuzhang Dummy Node*/
    //这个不大好搞, 还是method2吧
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next, n2 = head.next.next;
            // head->n1->n2->...
            // => head->n2->n1->...
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            
            // move to next pair
            head = n1;
        }
        
        return dummy.next;
    }
}

