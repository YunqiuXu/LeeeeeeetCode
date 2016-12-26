public class Solution {
    /**
     * 思路: 双指针
     * 一个从前往后一个从后往前
     */
    public String reverseVowels(String s) {
       char[] chars = s.toCharArray();
       String vowel = "aeiouAEIOU";
       int front = 0;
       int back = chars.length-1;
       while(front<back){
           while(front<back && !(vowel.contains(chars[front]+""))){
               front++;
           }
           while(front<back && !(vowel.contains(chars[back]+""))){
               back--;
           }
           char temp=chars[front];
           chars[front]=chars[back];
           chars[back]=temp;
           front++;
           back--;
       }
       
       return new String(chars);
    }
}
