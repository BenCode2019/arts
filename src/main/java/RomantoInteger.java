import java.util.HashMap;
import java.util.Map;

/**
 * 将罗马数字转换为十进制数
 * 如果左边的数字比右边的小就进行减法，反之进行加法
 * 从右往左便利较方便计算。
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 参考：https://www.cnblogs.com/f-zhao/p/6391790.html
 * Created by mengwei on 2019/4/18.
 */
public class RomantoInteger {

    private static Map<Character, Integer> map = new HashMap() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int preValue = 0;
        int rs = 0;
        for (int i = s.length()-1 ; i >= 0; i--) {
            char c = s.charAt(i);
            Integer curValue = map.get(c);
            if(preValue > curValue){
                rs -= curValue;
            }else{
                rs += curValue;
            }
            preValue = curValue;
        }
        return rs;
    }

    public static void main(String[] args) {
//        int iii = new RomantoInteger().romanToInt("III");
//        System.out.println("args = [" + iii + "]");
//        int LVIII = new RomantoInteger().romanToInt("LVIII");
//        System.out.println("args = [" + LVIII + "]");
        int LVIII = new RomantoInteger().romanToInt("IVVI");
        System.out.println("args = [" + LVIII + "]");
    }
}
