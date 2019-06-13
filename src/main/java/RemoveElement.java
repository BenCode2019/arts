/**
 * 27. Remove Element
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * 如例子中应该返回长度5和前五个元素为0,1,3,0,4
 *
 * Created by mengwei on 2019/6/13.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                // 因为要保证前五个数字不能包含val的值
                nums[j++]=nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return j;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,1,2,3,3,5,3,4};
        int[] nums = {3,2,2,3};
        int i = new RemoveElement().removeElement(nums, 3);
        System.out.println(i);
    }
}
