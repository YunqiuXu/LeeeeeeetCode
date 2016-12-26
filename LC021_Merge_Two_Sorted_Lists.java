/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author venturer
 *
 */

public class LC21_Merge_Two_Sorted_Lists {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
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
}
