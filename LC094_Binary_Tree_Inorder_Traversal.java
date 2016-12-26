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
    /** Recursive version
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList=new ArrayList<Integer>();
        if(root==null){
            return resultList;
        }
        List<Integer> leftList = inorderTraversal(root.left);
        List<Integer> rightList = inorderTraversal(root.right);
        resultList.addAll(leftList);
        resultList.add(root.val);
        resultList.addAll(rightList);
        return resultList;
    }*/
    
    
    /** Iterative version, 这个比较麻烦, 还需要再理解 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList=new ArrayList<Integer>();
        if(root==null){
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            //找到curr左子树左路径全都push进栈
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            resultList.add(curr.val);
            curr = curr.right;
        }
        return resultList;
    }
}
