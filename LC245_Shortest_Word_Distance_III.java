public class Solution {
    /** Yunqiu Xu*/
    //Similar to 243 Shortest Word Distance, but word1 could be the same as word2
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int currMinDist = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        
        for(int i = 0; i < words.length; i++){
            
            if(words[i].equals(word1)){
                if(same == true){
                    index1 = index2;
                    index2 = i;
                }
                else{
                    index1 = i;
                }
            }
            if(words[i].equals(word2)){
                index2 = i;
            }
            
            
            if(index1 != -1 && index2 != -1){
                currMinDist = Math.min(currMinDist, Math.abs(index1-index2));
            }
        }
        
        return currMinDist;
    }
}
