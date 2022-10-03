import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40 Combination Sum II
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * Created by mengwei on 2019/7/10.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(res,candidates,0,target,0,new ArrayList<Integer>());
        return res;
    }

    /**
     * start > i 想了半天，是由于i代入了递归代表的是当前递归的层级
     * @param res
     * @param candidates
     * @param sum
     * @param target
     * @param i
     * @param tmp
     */
    public void backtrack(List<List<Integer>> res,int[] candidates,int sum,int target,int i,List<Integer> tmp){
        if(target == sum){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        for (int start = i; start < candidates.length; start++) {
            if(sum + candidates[start] > target){
                break;
            }
            if (start > i && candidates[start] == candidates[start - 1]) {
                continue;
            }
            tmp.add(candidates[start]);
            backtrack(res,candidates,sum+candidates[start],target,start + 1,tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = new CombinationSumII().combinationSum2(candidates, 8);
        for (List<Integer> list :lists ) {
            for (Integer i:list) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }
}
