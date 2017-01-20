public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: stack, 这个方法感觉python要简单很多, java我没太看懂
     * 不断砍掉叶节点, 即将 "x,#,#"变为"#"
     * "9,3,4,#,#,1,#,#,2,#,6,#,#"
     * "9,3,4,#,#" --> "9,3,#"
     * "9,3,#,1,#,#" --> "9,3,#,#" --> "9,#"
     * "9,#,2,#,6,#,#" --> "9,#,2,#,#" --> "9,#,#" --> "#"
     */
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return true;
        }
        
        boolean flag = true;
        while (preorder.length() > 1) {
            int index = preorder.indexOf(",#,#"); //find the first ",#,#"
            if (index < 0) {
                flag = false;
                break;
            }
            int start = index;
            //find the index of prevprev element
            //e.g. In "9,3,4,#,#" we need to find the position of '3'
            while (start > 0 && preorder.charAt(start - 1) != ','){
                start --;
            }
            if (preorder.charAt(start) == '#') {
                flag = false;
                break;
            }
            preorder = preorder.substring(0, start) + preorder.substring(index + 3);
        }
        
        if (preorder.equals("#") && flag == true){
            return true;
        }
        else{ 
            return false;
        }
    }
    
    /** Method 2: 入度出度差
     * 所有的非空节点提供2个出度和1个入度（根除外）
     * 所有的空节点但提供0个出度和1个入度
     * diff = outdegree – indegree
     * 当一个节点出现的时候，diff – 1，因为它提供一个入度
     * 当节点不是#的时候，diff+2(提供两个出度) 
     * 如果序列式合法的，那么遍历过程中diff >=0 且最后结果为0
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes){
            diff--;
            if (diff < 0){
                return false;
            }
            if(!node.equals("#")){
                diff += 2;
            }
        }
        return diff == 0;
    }
}
