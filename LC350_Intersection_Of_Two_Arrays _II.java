public class Solution {
    /** Yunqiu Xu*/
    /** Method 1: 类似LC349, 但注意不能用set而使用list */
    /**public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } 
            else if (nums1[i] > nums2[j]) {
                j++;
            } 
            else {
                resultList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result=new int[resultList.size()];
        int k=0;
        while(!resultList.isEmpty()){
            result[k++]=resultList.remove(0);
        }
        return result;
    }*/
    /** Method 2: HashMap*/
    public int[] intersect(int[] nums1, int[] nums2) {
        //<number, count>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //将nums1中的元素存进哈希表
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i])+1);
            }
            else{
                map.put(nums1[i], 1);
            }
        }
    
        for(int i = 0; i < nums2.length; i++){
            //nums2中的元素在map中出现才可被加入结果
            //被加入结果一次频度-1
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
    
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++)
       {
           r[i] = result.get(i);
       }
    
       return r;
    }
}
