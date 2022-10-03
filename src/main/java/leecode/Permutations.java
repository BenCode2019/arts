import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * 参考 https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-by-powcai-2/
 * Created by mengwei on 2019/8/15.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = new Permutations().permute(nums);
        for (List<Integer> rs:permute) {
            System.out.println("");
            for (Integer i:rs) {
                System.out.print("[" + i + "]");
            }
        }
    }
}
