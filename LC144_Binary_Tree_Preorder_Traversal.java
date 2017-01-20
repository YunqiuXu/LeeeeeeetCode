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
    /** Recursive version */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        if(root == null){
            return resultList;
        }
        List<Integer> leftList = preorderTraversal(root.left);
        List<Integer> rightList = preorderTraversal(root.right);
        resultList.add(root.val);
        resultList.addAll(leftList);
        resultList.addAll(rightList);
        return resultList;
    }
    
    /** Iterative version, faster */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        if(root == null){
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            resultList.add(curr.val);
            //注意这里要先右后左
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return resultList;
    }
}
