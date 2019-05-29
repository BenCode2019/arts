import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Created by mengwei on 2019/5/29.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) != null && !stack.empty()){
                Character s1 = map.get(c);
                Character peek = stack.peek();
                if(peek.equals(s1)){
                    Character pop = stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }

    public boolean isValid2(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
//        boolean valid = new ValidParentheses().isValid("{[()]}");
//        System.out.println(valid);
//        boolean valid1 = new ValidParentheses().isValid("}}");
//        System.out.println(valid1);
        boolean valid2 = new ValidParentheses().isValid("(])");
        System.out.println(valid2);
    }
}
