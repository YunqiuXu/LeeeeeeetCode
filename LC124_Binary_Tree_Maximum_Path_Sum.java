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
    //all-left || all-right || from left to right
    // max left subpath(may be 0) + root + max right path(may be 0)
    public int maxPathSum(TreeNode root){
        ResultType result = helper(root);
        return result.maxPath; 
    }
    
    private class ResultType{
        // singlePath: max path from root, can have no node
        // maxPath: any node to any node, at least 1 node
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }
        //Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //Conquer
        //compute new single path
        int singlePath = Math.max(Math.max(left.singlePath, right.singlePath) + root.val, 0);
        //compute new max path
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }
}
