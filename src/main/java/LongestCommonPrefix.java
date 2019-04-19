/**
 * 最长共同前缀。
 * 会给一个字符串数组，例如["flower","flow","flight"]
 * 用两个循环，第一个循环第一个字符串的每个字符，第二个循环所有字符串的当前的字符。比较两个字符是否相等。
 * 如果相等则记录，不相等直接返回。
 *
 * 注意 ：1 对strs进行判空和第一个数组大并且 2 第二个数组与第一个数组完全一致的情况，【a,a】【a】
 * 参考：https://www.cnblogs.com/grandyang/p/4606926.html
 * Created by mengwei on 2019/4/19.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length<=0){
            return "";
        }
        String s = strs[0];
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean same = true;
            for (int j = 0; j < strs.length ; j++) {
                String str = strs[j];
                if(str.length() > i){
                    char c1 = str.charAt(i);
                    if(c != c1){
                        same = false;
                    }
                }else{
                    //在aa，a的时候需要判断
                    same = false;
                }
            }
            if(same){
                rs += c;
            }else{
                return rs;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"flower","flow","flight"};
        String s = new LongestCommonPrefix().longestCommonPrefix(str);
        System.out.println("args = [" + s + "]");

        String[] str2 = new String[]{"dog","racecar","car"};
        String s2 = new LongestCommonPrefix().longestCommonPrefix(str2);
        System.out.println("args = [" + s2 + "]");

        String[] str3 = new String[]{""};
        String s3 = new LongestCommonPrefix().longestCommonPrefix(str3);
        System.out.println("args = [" + s3 + "]");

        String[] str4 = null;
        String s4 = new LongestCommonPrefix().longestCommonPrefix(str4);
        System.out.println("args = [" + s4 + "]");

        String[] str5 = new String[]{"aa","a"};
        String s5 = new LongestCommonPrefix().longestCommonPrefix(str5);
        System.out.println("args = [" + s5 + "]");
    }
}
