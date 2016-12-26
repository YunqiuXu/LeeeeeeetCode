public class Solution {
    /** 思路: 先对两个链表进行排序, 去除重复值, 时间复杂度O(nlogn)*/
    /**    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
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
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
    */
    
    /**    另一种解法: 
    将一个数组全放进哈希表1中, 
    将另一个数组中元素与其比对, 若存在则放入结果表
    这个速度更快
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> Set1=new HashSet<Integer>();
        Set<Integer> resultSet=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            Set1.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            if(Set1.contains(nums2[j])){
                resultSet.add(nums2[j]);
            }
        }
        int[] result=new int[resultSet.size()];
        int k=0;
        for (Integer num : resultSet) {
            result[k++] = num;
        }
        return result;
    }
}
