/**
 * 55. Jump Game
 * Created by mengwei on 2019/9/9.
 */
public class JumpGame {

    /**
     * 方法1 回溯 采用的是低效的递归方法
     * 但是在leetcode中超时
     * @param position
     * @param nums
     * @return
     */
    private boolean canJump(int position,int[] nums){
        if(nums.length - 1 == position){
            return true;
        }
        //postion+nums[position] 从当前位置开始取当前位置的数字能跳动的最大长度
        int len = Math.min(position + nums[position],nums.length - 1);
        for (int i = position + 1; i <= len; i++) {
            boolean b = canJump(i, nums);
            // 每一步都递归一遍，直到有返回true的
            if(b){
                return true;
            }
        }
        return false;
    }
    /**
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        boolean b = canJump(0, nums);
        return b;
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }
    Index[] memo;

    /**
     * 方法2 自顶向下的动态规划 - 对于回溯的优化
     * 采用记录的方法进行优化
     * 将能达到终点的元素标记为GOOD简写G，否则记为B
     * 初始化时将memo都设置为UNKNOWN，将最后一个元素设置为GOOD
     * 但是在leetcode中超时
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        boolean b = canJump2(0, nums);
        return b;
    }

    private boolean canJump2(int position,int[] nums){
        if(nums.length - 1 == position){
            return true;
        }
        //postion+nums[position] 从当前位置开始取当前位置的数字能跳动的最大长度
        int len = Math.min(position + nums[position],nums.length - 1);
        for (int i = position + 1; i <= len; i++) {
            boolean b = canJump(i, nums);
            // 每一步都递归一遍，直到有返回true的
            if(b){
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    /**
     * 从右往左设置G和B
     * 从右往左依次比较当元素的值，所能到达的各个元素的memo。所以算法复杂度为n^2。
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }

    /**
     * 从右往左设置G和B 例如：
     * 3 2 1 0 4
     * B B B B G
     *
     * 2 3 1 1 4
     * G G G G G
     * @param nums
     * @return
     */
    public boolean canJump4(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
//        int[] nums = new int[]{3,2,1,0,4};

        boolean b = new JumpGame().canJump4(nums);
        System.out.println("args = [" + b + "]");
    }
}
