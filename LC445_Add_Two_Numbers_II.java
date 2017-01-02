/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //看了答案, 还需再理解!!
    /** Yunqiu Xu*/
    //题意是从尾部开始相加, 但不允许翻转链表
    //相似问题LC002, 那道题是从头部相加, 可以直接使用类merge操作
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        HashMap<Integer, Integer> hm1 = new HashMap<>(); //Store the 'index' and the value of List1
        HashMap<Integer, Integer> hm2 = new HashMap<>(); //Store the 'index' and the value of List2
        int i = 1, j = 1;
        
        while(l1 != null){
            hm1.put(i, l1.val);
            l1 = l1.next;
            i++;
        }
        while(l2 != null){
            hm2.put(j, l2.val);
            l2 = l2.next;
            j++;
        }
        
        int carry = 0;
        i--; 
        j--;
        ListNode head = null;
        
        //Create new nodes to the front of a new LinkedList
        while(i > 0 || j > 0 || carry > 0){

            int a = i > 0 ? hm1.get(i) : 0;
            int b = j > 0 ? hm2.get(j) : 0;
            int res = (a + b + carry) % 10;
            
            ListNode newNode = new ListNode(res);
            newNode.next = head;
            head = newNode;
            
            carry = (a + b + carry) / 10;
            i--; j--;
        }
        
        return head;
    }
}
