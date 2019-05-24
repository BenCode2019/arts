import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mengwei on 2019/5/22.
 */
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Integer,char[]> maps = new HashMap<Integer,char[]>();
        maps.put(2,new char[]{'a','b','c'});
        maps.put(3,new char[]{'d','e','f'});
        maps.put(4,new char[]{'g','h','i'});
        maps.put(5,new char[]{'j','k','l'});
        maps.put(6,new char[]{'m','n','o'});
        maps.put(7,new char[]{'p','q','r','s'});
        maps.put(8,new char[]{'t','u','v'});
        maps.put(9,new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<String>();
        if(digits.length() < 1){
            return result;
        }
        char[] arr = new char[digits.length()];
        loopLetter(maps, digits, 0,result,arr);
        return result;
    }

    public void loopLetter(Map<Integer,char[]> maps,String digits,Integer index,List<String> result,
                           char[] charsResult){
        if(index == digits.length()){
            result.add(new String(charsResult));
            return;
        }
        char c = digits.charAt(index);
        Integer digit = Integer.valueOf(String.valueOf(c));
        char[] chars = maps.get(digit);
        if(chars == null || chars.length <= 0){
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            charsResult[index] = chars[j];
            loopLetter(maps, digits, index + 1,result,charsResult);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinationsofaPhoneNumber().letterCombinations("2");
        for (String rs:strings) {
            System.out.println(rs);
        }
    }

}
