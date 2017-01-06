public class Solution {
    /** Yunqiu Xu*/
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int currMinDist = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length; i++){
            //在当前位置找到了新的word1
            if(words[i].equals(word1)){
                index1 = i;
            }
            //在当前位置找到了新的word2
            if(words[i].equals(word2)){
                index2 = i;
            }
            //比较更新后的距离和原来距离的大小
            if(index1 != -1 && index2 != -1){
                currMinDist = Math.min(currMinDist, Math.abs(index1-index2));
            }
        }
        
        return currMinDist;
    }
}
