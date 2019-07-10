import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * 参考 ：
 * https://leetcode-cn.com/problems/combination-sum/solution/xue-yi-tao-zou-tian-xia-hui-su-suan-fa-by-powcai/
 * Created by mengwei on 2019/7/10.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(res,candidates,target,0,new ArrayList());
        return res;
    }

    /**
     * i 是控制循环过之后的数字不在循环，而是从i之后的数开始循环
     * @param res
     * @param candidates
     * @param target
     * @param i
     * @param tmp
     */
    public void backtrack(List<List<Integer>> res,int[] candidates,int target,int i,List<Integer> tmp){
        if(target == 0){
            //需要将tmp的数据传入新list否则会被tmp.remove删掉
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(target < 0){
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if(target < candidates[start]){
                break;
            }
            tmp.add(candidates[start]);
            backtrack(res,candidates,target - candidates[start],start,tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] s = new int[]{2,3,6,7};
        List<List<Integer>> lists = new CombinationSum().combinationSum(s, 7);
        for (List<Integer> list :lists ) {
            for (Integer i:list) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }
}
