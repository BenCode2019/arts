/**
 * 28. Implement strStr()
 *
 * kmp算法解释
 * 继续拿之前的例子来说，当S[10]跟P[6]匹配失败时，KMP不是跟暴力匹配那样简单的把模式串右移一位，
 * 而是执行第②条指令：“如果j != -1，且当前字符匹配失败（即S[i] != P[j]），
 * 则令 i 不变，j = next[j]”，即j 从6变到2（后面我们将求得P[6]，即字符D对应的next 值为2），
 * 所以相当于模式串向右移动的位数为j - next[j]（j - next[j] = 6-2 = 4）
 *
 * https://blog.csdn.net/v_july_v/article/details/7041827
 *
 * 如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]。
 * 此举意味着失配时，模式串P相对于文本串S向右移动了j - next [j] 位。
 * 换言之，当匹配失败时，模式串向右移动的位数为：失配字符所在位置 - 失配字符对应的next 值（next 数组的求解会在下文的3.3.3节中详细阐述），
 * 即移动的实际位数为：j - next[j]，且此值大于等于1。
 *
 * java版本
 * https://blog.csdn.net/yuxin6866/article/details/52149585
 *
 * Created by mengwei on 2019/6/14.
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] kmp = computeKMP(needle);
        int i = 0, j = 0;//i is for haystack and j is for needle
        while (i < haystack.length()) {
            if (j == -1) {
                j = 0;
                i ++;
                continue;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() -1) {
                    return i - needle.length() + 1;
                }
                i ++;
                j ++;
            }
            else {
                j = kmp[j];
            }
        }
        return -1;
    }
    //calculate KMP array

    /**
     * KMP原理
     * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
     * 从首字母开始匹配，如果后面遇到相同的字符则left+1，right指针一直往后比较。直到结束。
     * @param needle
     * @return
     */
    private int[] computeKMP(String needle){
        int[] kmp = new int[needle.length()];
        int prefixEnd = -1;
        int suffixEnd = 0;
        kmp[0] = -1;
        //while loop updates kmp[suffixEnd + 1]
        while (suffixEnd < needle.length() - 1) {
            if (prefixEnd == -1 || needle.charAt(prefixEnd) == needle.charAt(suffixEnd)) {
                kmp[suffixEnd +1] = prefixEnd + 1;
                prefixEnd ++;
                suffixEnd ++;
            }
            else {
                prefixEnd = kmp[prefixEnd];
            }
        }
        return kmp;
    }

    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;

        for (int right = 1; right < needle.length(); right++) {
            int left = next[right - 1];
            char c = needle.charAt(left);
            char c1 = needle.charAt(right);
            while (left > 0 && c != c1) {
                left = next[left - 1];
            }

            if (c == c1) {
                next[right] = next[right - 1] + 1;
            } else {
                next[right] = 0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
//        int i = new ImplementStrStr().strStr("abcabdabcdabdca", "abcdabd");
        int i = new ImplementStrStr().strStr("aabaaabaaac", "aabaaac");
        System.out.println(i);
    }
}
