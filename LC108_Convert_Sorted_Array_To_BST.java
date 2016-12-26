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
    /** 思路: 中点即是root, 两边可执行递归*/
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        TreeNode root = helper(num, 0, num.length - 1);
        return root;
    }
    
    public TreeNode helper(int[] num, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, start, mid - 1);
        root.right = helper(num, mid + 1, end);
        return root;
    }
}
