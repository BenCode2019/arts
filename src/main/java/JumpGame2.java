/**
 * 45. Jump Game II
 * 参考 https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
 * Created by mengwei on 2019/8/12.
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            int s = nums[i] + i;
            maxPosition = Math.max(maxPosition, s);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        int jump = new JumpGame2().jump(nums);
        System.out.println("args = [" + jump + "]");
    }
}
