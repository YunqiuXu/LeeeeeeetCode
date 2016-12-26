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
    /**
     * 思路:
     * 1. 若左子树为空, 返回右子树高度+1
     * 2. 若右子树为空, 返回左子树高度+1
     * 3. 若均不为空, 返回高度比较小的那棵子树+1
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        else if(root.right == null){
            return minDepth(root.left) + 1;
        }
        else{
            return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
        }
    }
}
