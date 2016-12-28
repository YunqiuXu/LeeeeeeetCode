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
    /** Method: 
     * find position m
     * the changes begin from premNode, end at postnNode
     * ...premNode-mNode-...-nNode-postnNode --> ...premNode-nNode-...-mNode-postnNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        //set dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        //find premNode, and set it as current "head"
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;
        
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
    }
}
