/**
 * 44. Wildcard Matching
 * Created by mengwei on 2019/8/8.
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int preS = -1, preP = -1, i = 0, j = 0, len1 = s.length(), len2 = p.length();
        while(i < len1)
        {
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                preS = i+1;
                preP = j++;
            }
            else if(preP == -1) {
                return false;
            }
            else{
                i = preS;
                j = preP;
            }
        }
        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return i == len1 && j == len2;
    }

    public static void main(String[] args) {
//        boolean adceb = new WildcardMatching().isMatch("adceb", "*a*b");
        boolean adceb = new WildcardMatching().isMatch("aa", "a");
        System.out.println("args = [" + adceb + "]");
    }
}
