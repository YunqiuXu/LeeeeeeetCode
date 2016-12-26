public class Solution {
    //类似LC349, 但注意不能用set而使用list
    public int[] intersect(int[] nums1, int[] nums2) {
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
    }
}
