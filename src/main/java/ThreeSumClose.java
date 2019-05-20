import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * 3Sum Closest
 * 将三个数相加，找出三个数相加的和最接近target的数。
 * 我感觉要比threesum简单，因为不用判断重复的数。
 * 实现方法还是类似于threesum，先指定第一个数字，然后依次比对left与right，如果sum之和大于target就将right左移，反之亦然。
 * 参考：https://www.cnblogs.com/grandyang/p/4510984.html
 *
 * Created by mengwei on 2019/5/20.
 */
public class ThreeSumClose {

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3){
            return 0;
        }
        int diffNum = Math.abs((nums[0] + nums[1] + nums[2]) - target);
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right && left < nums.length - 1){
                int leftnum = nums[left];
                int rightnum = nums[right];
                int sum = num + leftnum + rightnum;
                int diffNewNum = Math.abs(sum - target);
                if(diffNum > diffNewNum){
                    diffNum = diffNewNum;
                    closest = sum;
                }
                if(sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,2,1,-4}; // -1 + 2 + 1 = 2
//        int[] nums = new int[]{0,0,0,0};
//        int[] nums = new int[]{0};
//        int[] nums = new int[]{1,9,10,-4,-5,0};
        int[] nums = new int[]{0,2,1,-3}; // 0
        int i = new ThreeSumClose().threeSumClosest(nums, 1);
        System.out.println(i);
    }
}
