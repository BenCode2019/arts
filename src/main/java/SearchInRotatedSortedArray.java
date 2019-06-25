/**
 * 33. Search in Rotated Sorted Array
 * 从左向右，如果左边的点比右边的点小，说明这两个点之间是有序的。
 * 如果左边的点比右边的点大，说明中间有个旋转点，所以一分为二后，肯定有一半是有序的。所以还可以用二分法。
 * 不过先要判断左边有序还是右边有序，如果左边有序，则直接将目标与左边的边界比较，就知道目标在不在左边，
 * 如果不在左边肯定在右边。然后在对右边进行二分法。
 * 参考:
 * https://www.cnblogs.com/zle1992/p/8996225.html
 * 图示:
 * https://www.cnblogs.com/grandyang/p/4325648.html
 * 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的
 *
 *
 * Created by mengwei on 2019/6/25.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) { //右半边有序
                if (nums[mid] < target && nums[right] >= target) {//目标是在右边
                    left = mid + 1;
                }
                else {  //目标值不在右边将right左移到左边，并再次二分查找
                    right = mid - 1;
                }
            } else {                       //左半边有序
                if (nums[left] <= target && nums[mid] > target) { //目标值在左边
                    right = mid - 1;
                }
                else {  //目标值不在左边将left右移到右边，并再次二分查找
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,7,0};
        int search = new SearchInRotatedSortedArray().search(nums, 6);
        System.out.println(search);
    }
}
