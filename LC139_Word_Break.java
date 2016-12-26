public class Solution {
    /** Yunqiu Xu*/
    /** check whether a word can be break as words in the dictionary
     * e.g. word = "leetcode", dict = ["leet","code"] --> true
     * application: you can get the word by searching the subword in dict
     */
    /** single-sequenced-related dp:
     * state: f[i] --> can the s[0:i] be partitioned?
     * function: f[i] = OR{f[j]}, j<i, s[j+1 ~ i] is a word in dict; 
     *      if all f[j] are false, then return false
     * initialize: f[0] = true
     * answer: f[s.length()]
     */
    //A tip: we do not to check the length of entire text, just the length of longest word in dict
    private int getMaxLength(Set<String> dict){
        int maxLength = 0;
        for(String word : dict){
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }

        int maxLength = getMaxLength(wordDict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            //all canSegment[i>0] are initialized as false
            canSegment[i] = false;
            for(int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++){
                if(canSegment[i-lastWordLength] == false){
                    continue;
                }
                String word = s.substring(i-lastWordLength, i);
                if(wordDict.contains(word)){
                    //if at least one is true, then true
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
}
