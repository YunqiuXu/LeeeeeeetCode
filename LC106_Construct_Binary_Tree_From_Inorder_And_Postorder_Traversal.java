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
    /** 思路: 可以借鉴LC105, 但还是不大理解
     * 1. 根据后序序列的最后一个元素建立根结点；
     * 2. 在中序序列中找到该元素，确定根结点的左右子树的中序序列；
     * 3. 在后序序列中确定左右子树的后序序列； 
     * 4. 由左子树的后序序列和中序序列建立左子树； 
     * 5. 由右子树的后序序列和中序序列建立右子树。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if (postStart < 0 || inStart < inEnd){
            return null;
        }
    
        TreeNode root = new TreeNode(postorder[postStart]);
        //find the index of the root from inorder. Iterating from the end.
        int rIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) {
                rIndex = i;
                break;
            }
        }
        root.right = helper(inorder, inStart, rIndex + 1, postorder, postStart-1);
        root.left = helper(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
        return root;
    }
}
