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
    /** Recursive
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        if(root.val <= p.val){
            //直到找到p的右子结点 or null
            return inorderSuccessor(root.right, p);
        }
        else{
            TreeNode succ = inorderSuccessor(root.left, p);
            if(succ != null){
                return succ;
            }
            return root;
        }
    }
    */
    /** Iterative */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } 
            else {
                root = root.right;
            }
        }
        return successor;
    }
}
