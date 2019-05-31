import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 1 如果在某次递归时，左括号的个数大于右括号的个数，
 * 说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现')('这样的非法串，所以这种情况直接返回。
 * 2 如果left和right都为0，则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。
 * 3 left大于0，则调用递归函数，若right大于0，则调用递归函数
 *
 * Created by mengwei on 2019/5/31.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> rs = new ArrayList<String>();
        int left = n;
        int right = n;
        help(left,right,"",rs);
        return rs;
    }

    public void help(int left,int right,String out,List<String> rs){
        if(left > right){
            return;
        }
        if(left == 0 && right == 0){
            rs.add(out);
            return;
        }
        if(left != 0){
            String out1 = out + "(";
            help(left-1,right,out1,rs);
        }
        if(right != 0){
            String out1 = out + ")";
            help(left,right-1,out1,rs);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParentheses().generateParenthesis(0);
        for (String string:strings) {
            System.out.println(string);
        }
    }

}
