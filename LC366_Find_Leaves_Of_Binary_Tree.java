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
    * 设置辅助函数, 从当前结点开始将子树的叶结点加进List
    * 同时将叶结点从子树中删除
    */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> currLeaves = new ArrayList<Integer>();
        while(root != null){
            if(isLeaf(root, currLeaves) == true){
                root = null;
            }
            resultList.add(currLeaves);
            currLeaves = new ArrayList<Integer>();
        }
        return resultList;
    }
    
    //if node is leaf, add its value to currLeaves
    private boolean isLeaf(TreeNode node, List<Integer> currLeaves){
        if(node.left == null && node.right == null){
            currLeaves.add(node.val);
            return true;
        }
        if(node.left != null){
            if(isLeaf(node.left, currLeaves) == true){
                node.left = null;
            }
        }
        if(node.right != null){
            if(isLeaf(node.right, currLeaves) == true){
                node.right = null;
            }
        }
        return false;
    }
}
