/**
 * 采用charAt来一位一位的取，比较char来确定是否在0-9的数字，排除掉字符串，最后进行乘10进行组装。
 * 注意边界和正负号的问题。
 * 参考：https://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
 *
 * 英文原题
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Created by mengwei on 2019/3/28.
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        // trim white spaces
        str = str.trim();

        if (str == null || str.length() < 1)
            return 0;

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i &&  str.charAt(i)>= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public static void main(String[] args) {
        char c = '0';
        char c1 = '9';
//        System.out.println(new StringtoInteger().myAtoi("42"));
//        System.out.println(new StringtoInteger().myAtoi("-42"));
//        System.out.println(new StringtoInteger().myAtoi("4193 with words"));
//        System.out.println(new StringtoInteger().myAtoi("words and 987"));
//        System.out.println(new StringtoInteger().myAtoi("+"));
        System.out.println(new StringtoInteger().myAtoi(""));
        System.out.println(new StringtoInteger().myAtoi("-91283472332"));

    }
}
