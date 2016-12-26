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
    /** 思路:
     * 求取左右子树高度
     * 若高度相同 --> 左子树一定全满了, 右子树不一定 --> 1 + (2^左高-1) + 右子树递归
     * 若高度不同 --> 左子树没满, 右子树满了但少一层 --> 1 + 左子树递归 + (2^右高-1)
     */
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight == rightHeight){
            return (1 << leftHeight) + countNodes(root.right);
        }
        else{
            return (1 << rightHeight) + countNodes(root.left);
        }
    }
    
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + height(node.left);
    }
}
