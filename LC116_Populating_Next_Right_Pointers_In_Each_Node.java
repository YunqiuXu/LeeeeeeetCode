/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: iterative */
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        TreeLinkNode prev = root;
        TreeLinkNode curr = null;
        while(prev.left != null){
            curr = prev;
            while(curr != null){
                //处理当前层
                curr.left.next = curr.right;
                if(curr.next != null){
                    //curr 不是当前层最右边的结点
                    curr.right.next = curr.next.left;
                }
                curr = curr.next; //当前层不断向右
            }
            prev = prev.left;
        }
    }
    
    /** Method 2: recursive */
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
    
        connect(root.left);
        connect(root.right);
    }
}
