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
    /** Method 1 : reverse the LL, then add one at head*/
    /** Method 2 : dummy node*/
    /** 思路:
     * 遍历链表，找到最后一个不为9的数字
     * 如果找不这样的数字(999..)
     * 在表头新建一个值为0的新节点，进行加1处理
     * 然后把右边所有的数字都置为0
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNot9 = dummy;
        ListNode curr = dummy;

        while (curr.next != null){
            curr = curr.next;
            if (curr.val != 9){
                lastNot9 = curr;
            }
        }
        
        lastNot9.val++;
        lastNot9 = lastNot9.next;
        while (lastNot9 != null) {
            lastNot9.val = 0;
            lastNot9 = lastNot9.next;
        }
        
        if (dummy.val != 0) {
            return dummy;
        }
        return dummy.next;
    }
}
