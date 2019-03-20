import java.util.HashSet;
import java.util.Set;

/**
 * leecode第三题,取子字符串中没有重复的字符最长的一组字符。
 * Created by mengwei on 2019/3/19.
 */
public class LongestSubstring {

    /**
     * 设定了一个窗口，不停地扩大窗口也就是右边不停地往右移，如果遇到重复的 就挪动窗口左边 直到到左边头一个出现重复的字母的位置。
     * 1 注意sum++的判断，要跟set的size比，是因为会删除重复字母之前所有的字母。
     * 2 遇到重复的字母从左边开始挨个删set里面的值，直到删到重复的那个字母为止。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int left = 0,right = 0,sum = 0;
        while(right < s.length()){
            final char c = s.charAt(right);
            if(!set.contains(c)){
                right++;
                set.add(c);
                if(sum < set.size()){
                    sum++;
                }
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int aewfgwb = new LongestSubstring().lengthOfLongestSubstring("aewfgwb");
        System.out.println(aewfgwb);
    }

}
