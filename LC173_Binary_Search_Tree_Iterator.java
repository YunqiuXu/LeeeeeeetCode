/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/** Yunqiu Xu*/
//这个设计有必要背一下
public class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curr;
    
    public BSTIterator(TreeNode root) {
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (curr != null || !stack.isEmpty()); 
    }

    /** @return the next smallest number */
    public int next() {
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        TreeNode result = curr;
        curr = curr.right;
        return result.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
