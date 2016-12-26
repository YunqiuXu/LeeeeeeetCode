/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
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
    //based on lc102
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList=new LinkedList<List<Integer>>();
        if(root==null){
            return resultList;
        }
        
        Queue<TreeNode> traversalQ=new LinkedList<TreeNode>();
        traversalQ.add(root);
        List<Integer> subList=new LinkedList<Integer>();
        
        subList.add(root.val);
        resultList.add(subList);
        int currIndex=0; //current level index
        
        while(!traversalQ.isEmpty()){
            subList=new LinkedList<Integer>();
            currIndex++;
            int currSize=traversalQ.size();
            
            for(int i=0;i<currSize;i++){
                TreeNode currNode=traversalQ.remove();
                if(currNode.left!=null){
                    subList.add(currNode.left.val);
                    traversalQ.add(currNode.left);
                }
                if(currNode.right!=null){
                    subList.add(currNode.right.val);
                    traversalQ.add(currNode.right);
                }
            }
            
            //if level index is odd, reverse the list
            if(subList.size()>0){
                if(currIndex%2 != 0){
                    Stack<Integer> stack=new Stack<Integer>();
                    while(!subList.isEmpty()){
                        stack.push(subList.remove(0));
                    }
                    while(!stack.isEmpty()){
                        subList.add(stack.pop());
                    }
                }
                resultList.add(subList);
            }
        }
        return resultList;
    }
}
