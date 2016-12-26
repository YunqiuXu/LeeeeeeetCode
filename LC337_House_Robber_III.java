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
    /** Method 1: veey slow
     * root is robbed --> root.left.left + root.left.right + root.right.left + root.right.right are robbed
     * root is not robbed --> root.left + root.right are robbed
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        
        if(root.left != null){
            sum += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            sum += rob(root.right.left) + rob(root.right.right);
        }
        
        return Math.max(sum+root.val, rob(root.left)+rob(root.right));
    }
    */
    //Method 2: use dp　看了答案
    public int rob(TreeNode root) {
        int[] maxVal = dpRob(root);
        return Math.max(maxVal[0], maxVal[1]);
    }
    public int[] dpRob(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } 
        else {
            //maxVal[0] --> max value without robing current node
            //maxVal[1] --> max value with robing current node
            int[] maxVal = new int[2]; 
            int[] leftMax = dpRob(root.left);
            int[] rightMax = dpRob(root.right);
            //不访问root --> 左右子结点最大值之和(可访问可不访问)
            maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
            //访问root --> 不访问左右子结点的最大值之和 + root.val
            maxVal[1] = leftMax[0] + rightMax[0] + root.val;
            return maxVal;
        }
    }
}
