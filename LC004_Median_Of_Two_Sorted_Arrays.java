public class Solution {
    /** Yunqiu Xu*/
    //我理解这道题思路, 但异常处理部分还需要再看下!!
    /** 思路: 
     * 我们建立一个辅助函数用于寻找 kth 元素
     * 比较两个数组k/2 th的元素A[k/2],B[k/2]
     * 若A[k/2] < B[k/2], 说明A[0:k/2]这些元素一定在kth 元素的前面
     * 因此我们可以将数组A缩短为A[k/2:]
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            //[1,2,3],[4,5] --> 3
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (
            //[1,2,3],[4,5,6] --> 3.5
            //找到第len/2和len/2+1的元素取其平均值
            findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k){    
        //A不存在 --> 直接在B数组中寻找
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        //B不存在 --> 直接在A数组中寻找
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }

        //找首元素: A和B首元素中比较小的
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        
        //若A[k/2]存在, 取A[k/2], 否则取无穷大
        int A_key = A_start + k / 2 - 1 < A.length
                    ? A[A_start + k / 2 - 1]
                    : Integer.MAX_VALUE;
        //若B[k/2]存在, 取B[k/2], 否则取无穷大
        int B_key = B_start + k / 2 - 1 < B.length
                    ? B[B_start + k / 2 - 1]
                    : Integer.MAX_VALUE; 
        
        if (A_key < B_key) { 
            //排除A数组中前k/2个元素
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } 
        else {
            //排除B数组中前k/2个元素
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
}
