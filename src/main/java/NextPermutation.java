/**
 * 31. Next Permutation
 *
 * 题意：
 * 产生下一个序列，对给定序列进行重排，生成一个字母顺序比它更大的下一个序列。
 * 如果给定的序列已经是按字母顺序排列中最大的一个了，则进行逆序排列。
 * 算法在数组内进行，不要使用额外空间。
 *
 * （1）从后向前遍历，找到第一个不满足降序的元素；若初始序列全部是降序，则i为-1，直接跳转至（3）；
 * （2）将该元素同它后面的元素中比它大的第一个元素交换；
 * （3）将该元素后的所有元素排列，使之成为最小的排列。
 *  实现参考: https://www.cnblogs.com/mydesky2012/p/5620006.html
 * Created by mengwei on 2019/6/20.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        //长度为1的数组
        if (nums.length == 1) {
            return;
        }

        // 1 从后向前找到第一个不满足逆序的元素 i
        int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; --i){
            ;
        } //注意，这里有=，可以排除含有重复元素的情况

        // 2 从i+1位置开始，向后查找比nums[i]大的最小元素，然后交换
        if(i >= 0){
            int j = i + 1;
            for(; j < nums.length && nums[j] > nums[i]; ++j){;}
            swap(nums,i,j - 1); //交换，注意是同 j - 1交换
        }

        // 3 将i之后的元素逆置,例如 [1,2,3] , [1,3,2,5,4]
        // (这里包含一种特殊情况，若该排列已经是字典序中的最大了，则下一个序列应该是最小字典序，因此，直接在这里逆置即可)
        int k = nums.length - 1;
        i++;
        for(; i < k; i++, k--){
            swap(nums, i, k);
        }
    }

    public void swap(int[] array,int i ,int j){
        //交换
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,5,4};// [1 3 2 5 4] [1 3 4 5 2] [1 3 4 2 5]
        int[] nums2 = {3,2,1};
        int[] nums3 = {1,1,5};

        new NextPermutation().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
