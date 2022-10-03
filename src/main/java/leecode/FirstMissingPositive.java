/**
 * 41. First Missing Positive
 * 有两种方法
 * 1 暂且叫将数变为负数
 * https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/
 * 2 桶排序
 * https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
 *
 * Created by mengwei on 2019/7/12.
 */
public class FirstMissingPositive {

    /**
     * 桶排序的方式 ，什么数字就要放在对应的索引上，其它空着就空着
     * 1 从头到尾依次循环将value交换至nums[value]中
     * 2 从头循环一遍 直到找到第一个符合nums[i]-1 != i条件的,也就是找出第一个不在正确的位置上的数
     * 注意 这里负数和大于数组长度的数都是"捣乱项"。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 前两个是在判断是否成为索引
            // 后一个是在判断，例如 3 在不在索引 2 上
            // 即 nums[i] ?= nums[nums[i]-1] 这里要特别小心
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 第 3 个条件不成立的索引的部分是 i 和 nums[i]-1
                int vindex = nums[i] - 1;
                swap(nums, vindex, i);
            }
        }
        //找出第一个不在正确的位置上的数
        for (int i = 0; i < len; i++) {
            // [1,-2,3,4]
            // 除了 -2 其它都满足： i+1 = num[i]
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public void swap(int[] nums,int vindex,int index){
        int tmp = 0;
        tmp = nums[vindex];
        nums[vindex] = nums[index];
        nums[index] = tmp;
    }

    /**
     * 变负数的方式,与桶类似，不同点是不交换数字而是将值变为负数
     * 1 判断是否存在1 如果不存在那 1 就是答案
     * 2 将负数 0 和大于n的数赋值为1
     * 3 将元素a的值对应下标 中的值赋值为负数 res[a]=-1*res[a]
     * 4 从头开始循环返回第一个正数的下标
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        // 基本情况
        int contains = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0){
            return 1;
        }

        // nums = [1]
        if (nums.length == 1){
            return 2;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num <= 0 || num > nums.length){
                nums[i] = 1;
            }
        }

        // 使用索引和数字符号作为检查器
        // 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
        // 如果 nums[2] 是正数 表示数字 2 没有出现
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            // 如果发现了一个数字 a - 改变第 a 个元素的符号
            // 注意重复元素只需操作一次
            if (a == nums.length){
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[a] = - Math.abs(nums[a]);
            }
        }

        // 现在第一个正数的下标
        // 就是第一个缺失的数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0){
                return i;
            }
        }

        if (nums[0] > 0){
            return nums.length;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,4,-1,-2,1,5,20,0,15};
        int[] nums = new int[]{2,1};
        int i = new FirstMissingPositive().firstMissingPositive2(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.print(" " + nums[j]);
        }
        System.out.println("");
        System.out.println("args = [" + i + "]");
    }
}
