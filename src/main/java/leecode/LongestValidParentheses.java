import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * 给定一个只包含 ‘(’ 和 ‘)’ 的字符串，找出 (最长的包含有效括号的子串) 的长度。
 * 例如: ())(()) 就只有(())才有效，如果这样()(())有效的就是6个。
 *
 *
 *
 * 有四种解法
 * 1 第一种就是暴力算法全部比对一遍。
 * 2 采用动态规划算法 todo 暂时还没想好逻辑
 * 3 采用栈的算法
 * 开始想将 "(" 压入栈，遇到 ")" 在弹出栈，可是())(())这样情况就会统计出6.
 * 所以改为记录"("索引数字，当遇到"("时弹出stack，并将 (i - 上一个索引值)作为最长连续数量。
 * 4 采用left和right指针的算法
 *
 *
 * Created by mengwei on 2019/6/24.
 */
public class LongestValidParentheses {

    /**
     * 开始想将 "(" 压入栈，遇到 ")" 在弹出栈，可是())(())这样情况就会统计出6.
     * 所以改为记录"("索引数字，当遇到"("时弹出stack，并将 (i - 上一个索引值)作为最长连续数量。
     * 因为i - stack.peek肯定是当前两个括号之间有效的长度
     * 例如:
     * ( ( ( ) ( ( ) ( ) )
     * 1 2 3 4 5 6 7 8 9 10
     * 计算 3 ~ 10 就是 10 - 2         = 8
     *                 i - stack.peek = 8
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        int maxans = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    start = i + 1;
                }else {
                    stack.pop();
                    if(stack.empty()){
                        maxans = Math.max(maxans, i - start + 1);
                    }else{
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
        }
        return maxans;
    }

    /**
     * 栈的优化版本，去掉start，在栈为空的时候push进去i当前的位置，所以就不用判断栈空的条件。
     * @param s
     * @return
     */
    public int longestValidParentheses31(String s) {
        int maxans = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 如果是")"
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    int i1 = i - stack.peek();
                    maxans = Math.max(maxans, i1);
                }
            }
        }
        return maxans;
    }

    /**
     * 采用左右指针
     * 先从做往右循环，记录left和right的数，当left==right的时候，计算当前有效字符串长度。
     * 然后从右往左再做一遍。（注意两个循环之间要清空left和right）
     * @param s
     * @return
     */
    public int longestValidParentheses4(String s) {
        int left = 0;
        int right = 0;
        int maxans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxans = Math.max(maxans, left + right);
            }else if(right > left){
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)==')'){
                right++;
            }else{
                left++;
            }
            if(left == right){
                maxans = Math.max(maxans, left + right);
            }else if(left > right){
                left = 0;
                right = 0;
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        int i = new LongestValidParentheses().longestValidParentheses3(")()())");
//        int i = new LongestValidParentheses().longestValidParentheses("())(())");
//        int i = new LongestValidParentheses().longestValidParentheses4(")((()(()())");

        System.out.println(i);

    }
}
