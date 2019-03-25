import static java.lang.Math.min;

/**
 * 这个题目有点绕，先弄清楚这道题到底在问什么。一旦清楚它到底在问什么，就好解决这个问题了。
 * 1 两个有序的数组nums1和nums2
 * 2 取两个数组的中位数,中位数的定义是
 * 给定两个已经升序排序过的数组，求这两个数组的中位数；
 * 中位数的定义为把两个数组合并过后进行升序排序后，处于数组中间的那个数，
 * 此时如果合并后的数组元素个数为偶数，则为中间两个数的平均值。
 * 例如：
 * [1,3],[2] = 2
 * [1,2],[3,4] = (2+3) / 2 = 2.5
 * 参考: http://www.cnblogs.com/grandyang/p/4465932.html
 * Created by mengwei on 2019/3/21.
 */
public class MediaOfTwoSortedArrays {

    /**
     * 我们使用一个小trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。
     * 加入 m+n 为奇数的话, 那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身.
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int one = findKth(nums1,0,nums2,0,left);
        int two = findKth(nums1,0,nums2,0,right);
        return (one + two) / 2.0;
    }

    /**
     * 1 比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，
     * 相当于一个空数组了，那么实际上就变成了在另一个数组中找数字。
     * 2 比较这两个数组的第K/2小的数字midVal1和midVal2的大小,如果第一个数组的第K/2个数字小的话，
     * 那么说明我们要找的数字肯定不在nums1中的前K/2个数字，
     * 所以我们可以将其淘汰，将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。
     * 3
     *
     * @param nums1
     * @param i 表示nums1的起始位置
     * @param nums2
     * @param j 表示nums2的起始位置
     * @param k
     * @return
     */
    int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if(i >= nums1.length){
            return nums2[j + k - 1];
        }
        if(j >= nums2.length){
            return nums1[i + k - 1];
        }
        if(k == 1){
            return min(nums1[i],nums2[j]);
        }
        int middleValue1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1]:Integer.MAX_VALUE;
        int middleValue2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1]:Integer.MAX_VALUE;
        if(middleValue1 < middleValue2){
            return findKth(nums1,i + k / 2,nums2,j,k - k / 2) ;
        }else{
            return findKth(nums1,i,nums2,j + k / 2,k - k / 2) ;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {3,5,8,9};
        int[] nums2 = {1,2,7,10,11,12};

        double medianSortedArrays2 = new MediaOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays2);
    }
}
