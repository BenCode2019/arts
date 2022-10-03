/**
 *
 * 题意：参考https://www.cnblogs.com/grandyang/p/4461713.html
 * 这道求正则表达式匹配的题和那道 Wildcard Matching 的题很类似，不同点在于*的意义不同，在之前那道题中，*表示可以代替任意个数的字符，
 * 注意:而这道题中的*表示之前那个字符可以有0个，1个或是多个，就是说，字符串a*b，可以表示b或是aaab，即a的个数任意。
 *
 * 解题思路参考:https://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 * 先简化为两种基础情况
 * 1 第二个需要匹配的字符不是"*"
 * 2 第二个需要匹配的字符是"*"
 * 第一种情况下 如果第一个pattern字符不是"." ,则第一个的pattern字符与string应该是相同的的，然后匹配后面的部分。
 * 第二种情况下 如果第一个pattern字符是"." 或第一个的pattern字符与string第一个字符相同，然后匹配后面的部分。
 *
 * Created by mengwei on 2019/4/3.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aaab";
        String p = "a*b";
        System.out.println(new RegularExpressionMatching().isMatch("aa","a")); //false
        System.out.println(new RegularExpressionMatching().isMatch("aa","aa")); //true
        System.out.println(new RegularExpressionMatching().isMatch("aaa","aa"));//false
        System.out.println(new RegularExpressionMatching().isMatch("aa","a*"));//true
        System.out.println(new RegularExpressionMatching().isMatch("aa",".*"));//true
        System.out.println(new RegularExpressionMatching().isMatch("ab",".*"));//true
        System.out.println(new RegularExpressionMatching().isMatch("aab","c*a*b"));//true
        System.out.println(new RegularExpressionMatching().isMatch("ab",".*c"));//false
        System.out.println(new RegularExpressionMatching().isMatch("a",".*..a"));//false
        System.out.println(new RegularExpressionMatching().isMatch("mississippi","mis*is*p*."));//false
        System.out.println(new RegularExpressionMatching().isMatch("ssi","s*"));//false
    }

    /**
     * 较容易理解，但是速度慢，用动态规划要快
     * @param s
     * @param p
     * @return
     */
    private boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        // special case
        if (p.length() == 1) {
            // 1 if the length of s is 0, return false
            if (s.length() < 1) {
                return false;
            }
            // 2 if the first does not match, return false
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }
            // 3 otherwise, compare the rest of the string of s and p.
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        if (p.charAt(1) != '*') {
            // "a",".*..a" 情况s的length会为0
            if(s.length() < 1){
                return false;
            }
            if (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        } else {
            // 如果字符串是aab pattern是a*b的话就会进入下面的while，挨个循环aab字符进行比较。
            // 因为第一个单词不匹配的话就会返回false（special case 1）
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            int i = 0;
            //s.length()>i是因为"ab",".*c" 时，s的length会小于i。
            while (s.length() > i && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    /**
     * 采用动态规划的版本，比普通的要快几十倍
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
