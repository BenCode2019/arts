import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
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
