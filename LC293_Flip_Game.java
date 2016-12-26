/*
* https://leetcode.com/problems/flip-game/
*
**/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> resultList=new ArrayList<String>();
        if(s.length()<2){
            return resultList;
        }
        
        int currIndex=0;
        while(currIndex<s.length()-2){
            if(s.substring(currIndex,currIndex+2).equals("++")){
                resultList.add(s.substring(0,currIndex)+"--"+s.substring(currIndex+2));
            }
            currIndex++;
        }

        //The last one
        if(s.substring(currIndex,currIndex+2).equals("++")){
            resultList.add(s.substring(0,currIndex)+"--");
        }
        return resultList;
    }
}
