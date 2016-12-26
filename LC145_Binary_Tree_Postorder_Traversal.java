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
    /** recursive version
    public ArrayList<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if(root == null){
            return result;
        }
        //devide
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        //conquer
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    } */
    /** iterative: similar to preorder */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return result;   
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            //从前面添加
            result.addFirst(cur.val);
            //这里和前序刚好相反, 先左后右
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            } 
        }
        return result;
    }
}
