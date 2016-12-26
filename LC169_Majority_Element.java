public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: Moore Voting
     * 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素 
     * 如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e
     */
    /** public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int curr = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){ //重新再来
                curr = nums[i];
                count++;
            }
            else if(curr == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return curr;
    }*/
    
    /** Method 2: Java buildin sort */
    /** public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
    
    /** Method 3: HashMap*/
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
        int result =0;
        for (int num: nums) {
            if (!myMap.containsKey(num)){
                myMap.put(num, 1);
            }
            else{
                myMap.put(num, myMap.get(num)+1);
            }
            if (myMap.get(num) > nums.length/2) {
                result = num;
                break;
            }
        }
        return result;
    }
}
