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
    /** Yunqiu Xu 基于中序遍历*/
    //首先初始化三个指针
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traversal(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    public void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        
        // If first element to swap has not been found, assign it to prevElement
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        // If first element is found, assign the second element to the root
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;
        
        traversal(root.right);
    }
}
