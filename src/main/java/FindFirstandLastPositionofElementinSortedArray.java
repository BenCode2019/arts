/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * 1 采用二分法找到target后，left向前和right向后，直至找到 target 出现的最大、最小下标。
 * 参考:
 * https://www.cnblogs.com/skillking/p/9440811.html
 *
 * 2 第二种解法是从左采用二分法找到第一个target，然后从右采用二分法找到第二个target。
 * 参考:leetcode 上有图示
 *
 * Created by mengwei on 2019/6/26.
 */
public class FindFirstandLastPositionofElementinSortedArray {

    /**
     * 采用二分法找到target后，left向前和right向后，直至找到 target 出现的最大、最小下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] rs = new int[]{-1,-1};
        int left = 0;
        int right = nums.length - 1;
        if(nums.length == 0)
        {
            return rs;
        }
        if(target < nums[left] || target > nums[right])
        {
            return rs;
        }
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
                right = mid;
                while(left-1 >= 0 && nums[left-1] == target){
                    left--;
                }while(right+1 < nums.length && nums[right+1] == target){
                    right++;
                }
                break;
            }
        }
        if(nums[left] == target) {
            rs[0] = left;
            rs[1] = right;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + (4-3)/2 + "]");

        int[] nums = {5,7,7,8,8,10};
        int[] ints = new FindFirstandLastPositionofElementinSortedArray().searchRange(nums, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("args = [" + ints[i] + "]");
        }
    }
}
