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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    public int maxDepth(TreeNode currNode){
        if(currNode == null){
            return 0;
        }
        int leftHeight = maxDepth(currNode.left);
        int rightHeight = maxDepth(currNode.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
