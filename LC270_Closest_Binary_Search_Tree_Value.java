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
    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        int closest = curr.val;
        
        while(curr != null){
            if(Math.abs(target - curr.val) < Math.abs(target - closest)){
                closest = curr.val;
            }
             
            if(curr.val > target){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        
        return closest;
    }
}
