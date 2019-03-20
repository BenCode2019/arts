import java.util.HashMap;

/**
 * 给一个数组和一个目标值，获取数组中某两个数相加等于这个target的下标。
 * Created by mengwei on 2019/3/18.
 */
public class TwoSum {
    /**
     *
     * 1 如果采用两层循环的话时间复杂度是O(n^2),所以采用map的方式来存储访问过的number,时间复杂度为O(n).
     * 2 开始出现了一个错误，将map.put放到了for循环第一行，这样当输入[3,2,4],6的时候会出现bug，有兴趣的可以试一下。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap();
        for(int i=0; i < nums.length;i++){
            int number = target - (int)nums[i];
            Integer index = (Integer)map.get(number);
            if(index != null){
                int[] rs = new int[2];
                rs[0] = i;
                rs[1] = index;
                return  rs;
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] s = {3,2,4};
        int[] ints = new TwoSum().twoSum(s, 6);
        System.out.println(ints);
    }

}
