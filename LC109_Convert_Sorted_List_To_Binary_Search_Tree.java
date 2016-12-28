/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /** Yunqiu Xu*/
    private ListNode current;

    //return the size of linkedlist
    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    //convert LL to BST
    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }
        
        //set left half as left subtree
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        //set right half as right subtree
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        //因为这里head会变, 所以要先保存下
        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }
}
