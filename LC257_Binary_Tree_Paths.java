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
    //类似先序遍历, 形成字符串的过程不大会, 看的答案
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null){
            return paths;
        } 
        
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

        for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
        }

        for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
        }

        return paths;
    }
}
