/**
 * 26. Remove Duplicates from Sorted Array。
 *
 * 我们使用快慢指针来记录遍历的坐标，最开始时两个指针都指向第一个数字，
 * 如果两个指针指的数字相同，则快指针向前走一步，
 * 如果不同，则两个指针都向前走一步，
 * 这样当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数
 * Created by mengwei on 2019/6/12.
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(fast < nums.length){
            if(nums[fast] == nums[slow]){
                fast++;
            }else{
                //这步不只是更新了pre和cur，还需要更新nums数组的值： {1,2,2,3,4,4,5};
                //nums[++pre] = nums[cur++]
                //在第三步的时候，实际上数组已经变成了1,2,3,3,4,4,5
                //所以pre指向第二个3和4的时候，就不会再往后移动了
                nums[++slow]=nums[fast];
                fast++;
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,5};
        int i = new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
        System.out.println(i);
    }

}
