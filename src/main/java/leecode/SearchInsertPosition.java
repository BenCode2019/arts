/**
 * 35. Search Insert Position
 *
 * 在一个排好序的数组查找某值，存在则返回对应的value,不存在则返回能插入到数组中的index，  其实就是找到第一个大于等于目标值的下标。
 *
 * Created by mengwei on 2019/6/27.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2; //第二种求mid方式 left + (right - left)/2;
            //找到最后一个大于等于目标值的下标并将right设置好
            //然后将left设置为right的右侧
            //值在左侧
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,7};
        int i = new SearchInsertPosition().searchInsert(nums, 5);
        System.out.println("args = [" + i + "]");
        System.out.println("args = [" + 1/3  + "-"+ 2%3 + "]");
    }
}
