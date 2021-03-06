import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
     A solution set is:
     [
         [-1, 0, 1],
         [-1, -1, 2]
     ]
     这道题让我们求三数之和，比之前那道Two Sum要复杂一些，博主考虑过先fix一个数，然后另外两个数使用Two Sum那种HashMap的解法，
     但是会有重复结果出现，就算使用set来去除重复也不行，会TLE，看来此题并不是考我们Two Sum的解法。
     那么我们来分析一下这道题的特点，要我们找出三个数且和为0，那么除了三个数全是0的情况之外，肯定会有负数和正数，
     我们还是要先fix一个数，然后去找另外两个数，我们只要找到两个数且和为第一个fix数的相反数就行了，
     既然另外两个数不能使用Two Sum的那种解法来找，如果能更有效的定位呢？我们肯定不希望遍历所有两个数的组合吧，
     所以如果数组是有序的，那么我们就可以用双指针以线性时间复杂度来遍历所有满足题意的两个数组合。
     我们对原数组进行排序，然后开始遍历排序后的数组，这里注意不是遍历到最后一个停止，而是到倒数第三个就可以了。
     这里我们可以先做个剪枝优化，就是当遍历到正数的时候就break，为啥呢，因为我们的数组现在是有序的了，如果第一个要fix的数就是正数了，
     那么后面的数字就都是正数，就永远不会出现和为0的情况了。然后我们还要加上重复就跳过的处理，处理方法是从第二个数开始，
     如果和前面的数字相等，就跳过，因为我们不想把相同的数字fix两次。对于遍历到的数，用0减去这个fix的数得到一个target，
     然后只需要再之后找到两个数之和等于target即可。我们用两个指针分别指向fix数字之后开始的数组首尾两个数，
     如果两个数和正好为target，则将这两个数和fix的数一起存入结果中。然后就是跳过重复数字的步骤了，两个指针都需要检测重复数字。
     如果两数之和小于target，则我们将左边那个指针i右移一位，使得指向的数字增大一些。
     同理，如果两数之和大于target，则我们将右边那个指针j左移一位，使得指向的数字减小一些，代码如下：
     参考 https://www.cnblogs.com/grandyang/p/4481576.html


    注意：重复问题弄了好半天，注意[0,0,0,0],[-1,-1,0,1]，还要注意判断出来一个数字以后要left++和right++
 * Created by mengwei on 2019/4/19.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return rs;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 加上重复就跳过的处理，处理方法是从第二个数开始，如果和前面的数字相等，就跳过，因为我们不想把相同的数字fix两次.
            // 例如：[0,0,0,0]
            if(num > 0){
                continue;
            }

            int right = nums.length - 1;
            int left = i + 1;
            if(left > nums.length - 1){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //注意 参数为[0,0,0]left会大于right导致数组下标越界
            while(right != left && left < right){
                int numleft = nums[left];
                int numright = nums[right];
                int sum = numleft + numright + num;
                if(sum == 0){
                    List rs1 = new ArrayList<Integer>();
                    rs1.add(num);
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
                }else if(sum < 0){
                    left ++;
                }else{
                    right --;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
//        int[] ints = {-1, 0, 1, 2, -1, -4};   //[[-1,-1,2],[-1,0,1]]
//        int[] ints = {0,1};
//        int[] ints = {0,0,0};
//        int[] ints = {0,0,0,0};
//        int[] ints = {1,-1,-1,0};   //[[-1,0,1]]
        int[] ints = {3,0,-2,-1,1,2}; //[[-2,-1,3],[-2,0,2],[-1,0,1]]
        List<List<Integer>> lists = new ThreeSum().threeSum(ints);
        for (List<Integer> list:lists) {
            for (Integer i:list) {
                System.out.println("args = [" + i + "]");
            }
        }
    }
}
