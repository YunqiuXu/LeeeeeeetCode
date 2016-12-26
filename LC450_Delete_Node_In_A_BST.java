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
    /** 思路: find successor */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{//find the node
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //both right & left are not null
            TreeNode successor = findSuccessor(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
