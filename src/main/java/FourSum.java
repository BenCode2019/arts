import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 此题的O(n^3)解法的思路跟 3Sum 基本没啥区别，就是多加了一层for循环，其他的都一样。
 *
 * 判断重复用set来进行去重复的处理还是有些取巧，可能在Java中就不能这么做，那么我们还是来看一种比较正统的做法吧，
 * 手动进行去重复处理。主要可以进行的有三个地方，首先在两个for循环下可以各放一个，因为一旦当前的数字跟上面处理过的数字相同了，
 * 那么找下来肯定还是重复的。之后就是当sum等于target的时候了，我们在将四个数字加入结果res之后，left和right都需要去重复处理，
 * 分别像各自的方面遍历即可。
 *
 * 参考:https://www.cnblogs.com/grandyang/p/4515925.html
 * Created by mengwei on 2019/5/24.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return rs;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 加上重复就跳过的处理，处理方法是从第二个数开始，如果和前面的数字相等，就跳过，因为我们不想把相同的数字fix两次.
            // 首先在两个for循环下可以各放一个，因为一旦当前的数字跟上面处理过的数字相同了，那么找下来肯定还是重复的
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 首先在两个for循环下可以各放一个，因为一旦当前的数字跟上面处理过的数字相同了，那么找下来肯定还是重复的
                if(j != i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int right = nums.length - 1;
                int left = j + 1;
                if(left > nums.length - 1){
                    continue;
                }
                int num2 = nums[j];
                //注意 参数为[0,0,0]left会大于right导致数组下标越界
                while(right != left && left < right){
                    int numleft = nums[left];
                    int numright = nums[right];
                    int sum = numleft + numright + num + num2;
                    if(sum == target){
                        List rs1 = new ArrayList<Integer>();
                        rs1.add(num);
                        rs1.add(num2);
                        rs1.add(numleft);
                        rs1.add(numright);
                        rs.add(rs1);
                        left++;
                        right--;
                        //防止第一个数为0后面的也为0，避免两个指针检查重复的数字。例如 [0,0,0,0]
                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }else if(sum < target){
                        left ++;
                    }else{
                        right --;
                    }
                }
            }
        }
        return rs;
    }

    private void test(int[] nums,int i){
        List<List<Integer>> lists = new FourSum().fourSum(nums, i);
        for (List<Integer> list:lists) {
            StringBuffer s = new StringBuffer();
            for (Integer rs:list ) {
                s.append(rs);
                s.append("|");
            }
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,0,-1,0,-2,2};   // [-1,  0, 0, 1],  [-2, -1, 1, 2],  [-2,  0, 0, 2]
        new FourSum().test(nums1,0);
        System.out.println("--------------");

        int[] nums2 = {0,0,0,0};   // [0,0,0,0]
        new FourSum().test(nums2,0);
        System.out.println("--------------");

        int[] nums3 = {0,0,0,0};   // [0,0,0,0]
        new FourSum().test(nums3,1);
        System.out.println("--------------");

        int[] nums4 = {0,4,-5,2,-2,4,2,-1,4};  //[[0,4,4,4],[2,2,4,4]]
        new FourSum().test(nums4,12);
        System.out.println("--------------");
    }
}
