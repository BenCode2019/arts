/**
 * 找出字符串中最长的回文。
 * 比较简单的做法是循环每一个字符，然后针对这个字符找左边和右边，如果相等就记录下来。
 * 把每个字符的回文长度都记下来，最后留下最大的回文。
 * 参考:https://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 * Created by mengwei on 2019/3/26.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() <= 0){
            return s;
        }
        String longestStr = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            //奇数的回文
            String scan = scan(s, i,i);
            if(longestStr.length() < scan.length()){
                longestStr = scan;
            }
            //偶数的回文
            String scan2 = scan(s, i,i+1);
            if(longestStr.length() < scan2.length()){
                longestStr = scan2;
            }
        }
        return longestStr;
    }

//    从某个单词开始扫描，不停地扫描他的前一个和后一个字符
    public String scan(String s,Integer begin,Integer end){
        while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        String substring = s.substring(begin + 1, end);
        return substring;
    }

    public static void main(String[] args) {
        String s = "abbba";
//        String s = "";
        String s1 = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(s1);
    }
}
