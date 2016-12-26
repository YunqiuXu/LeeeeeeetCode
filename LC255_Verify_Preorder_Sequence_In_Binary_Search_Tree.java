public class Solution {
    /** Yunqiu Xu*/
    /** 思路: 
     * 第一个元素为root
     * 第一个比root小的元素为左子结点
     * 第一个比root大的元素为右子结点
     */
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return true;
        } 
        return verify(preorder, 0, preorder.length - 1);
    }
    
    public boolean verify(int[] preorder, int start, int end){
        if(start > end){ //end
            return true;
        }
        
        int currRoot = preorder[start];
        int bigger = -1;
        for(int i = start + 1; i <= end; i++) {
            // condition 1: bigger == -1 && preorder[i] <= currRoot --> preorder[i] is the left child --> continue
            // condition 2: bigger == -1 && preorder[i] > currRoot --> preorder[i] is the first right child --> change bigger
            if(bigger == -1 && preorder[i] > currRoot) {
                bigger = i;
            }
            // condition 3: bigger != -1 --> has been to the right subtree --> all preorder[i] should be larger than currRoot
            if(bigger != -1 && preorder[i] < currRoot) {
                return false;
            }
        }
        //all the rest are in the left subtree
        if(bigger == -1) {
            return verify(preorder, start + 1, end);
        }
        //check left subtree && right subtree
        else {
            return verify(preorder, start + 1, bigger - 1) && verify(preorder, bigger, end);
        }
    }
}
