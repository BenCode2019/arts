import java.util.HashMap;

/**
 * Created by mengwei on 2019/3/18.
 */
public class TwoSum {
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
