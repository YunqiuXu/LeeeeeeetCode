/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /** Yunqiu Xu*/
    //The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
    //If candidate knows i, then switch candidate. The second pass is to check whether the candidate is real.
    public int findCelebrity(int n) {
        int id = 0;
        for(int i = 1; i < n; i++){
            if(knows(id, i)){ // id is not celebrity, i maybe the celebrity
                id = i; 
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != id && (knows(id, i) || !knows(i, id))){ 
                //for a non-celebrity i, id knows i(id is not cele) or i doesn't know id
                return -1;
            } 
        }
        return id;
    }
}
