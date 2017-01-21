public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: 两次遍历
     * 第一次遍历找出所有位置相同且值相同的数字，即bulls，并且记录secret中不是bulls的数字出现的次数
     * 然后第二次遍历guess中不是bulls的位置，如果在哈希表中存在，cows自增1，然后映射值减1
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] hash = new int[10];
        
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            else{
                hash[secret.charAt(i) - '0']++;
            }
        }
        
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) != guess.charAt(i) && hash[guess.charAt(i) - '0'] > 0){
                cows++;
                hash[guess.charAt(i) - '0']--;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
    
    /** Method 2: 一次遍历
     * 在处理不是bulls的位置时,
     * 如果secret当前位置数字的映射值小于0，则表示其在guess中出现过，cows自增1，然后映射值加1
     * 如果guess当前位置的数字的映射值大于0，则表示其在secret中出现过，cows自增1，然后映射值减1
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] hash = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            else{
                if(hash[secret.charAt(i) - '0'] < 0){
                    cows++;
                }
                hash[secret.charAt(i) - '0']++;
                if(hash[guess.charAt(i) - '0'] > 0){
                    cows++;
                }
                hash[guess.charAt(i) - '0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
