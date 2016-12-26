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
    /** Yunqiu Xu */
    /** Method 1: 比较麻烦
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> resultList = inorderTraversal(root);
        if(resultList.size() == 0){
            return -1;
        }
        int count = 1;
        int curr = resultList.remove(0);
        while(count < k && !resultList.isEmpty()){
            count++;
            curr = resultList.remove(0);
        }
        return curr;
    }
    
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> resultList=new ArrayList<Integer>();
        if(root==null){
            return resultList;
        }
        if(root.left!=null){
            List<Integer> leftList=inorderTraversal(root.left);
            resultList.addAll(leftList);
        }
        resultList.add(root.val);
        if(root.right!=null){
            List<Integer> rightList=inorderTraversal(root.right);
            resultList.addAll(rightList);
        }
        return resultList;
    }
    */
    /** Method 2
     * 先计算左子树的结点数count, 若count>=k, 说明结果在左子树中, 执行递归
     * 若k>count+1, 说明在右子树中, 递归求右子树第k-1-count小的元素
     */
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } 
        else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count);
        }
        
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
