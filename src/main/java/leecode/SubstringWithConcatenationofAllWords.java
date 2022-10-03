//import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * 参考:
 * https://www.cnblogs.com/grandyang/p/4521224.html
 * https://juejin.im/entry/5bf4e1d56fb9a049f745d291
 * Created by mengwei on 2019/6/18.
 */
public class SubstringWithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> wordMap = new HashMap<String,Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        if(s == null || s.length() <= 0 || words.length <= 0){
            return ans;
        }
        int wordLength = words[0].length();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(wordMap.get(word) != null){
                wordMap.put(word,wordMap.get(word)+1);
            }else{
                wordMap.put(words[i],1);
            }
        }
        int left = 0;
        int right = 0;
        int arrLength = words.length;
        int tempArrLength = 0;

        Map<String, Integer> temp = new HashMap<String,Integer>();
        while(right + wordLength <= s.length()){
            String tempWord = s.substring(right, right + wordLength);
            Integer value = wordMap.get(tempWord);
            Integer tempValue = temp.get(tempWord);
            if (value != null && (tempValue == null || tempValue < value)) {
                if (tempValue == null) {
                    tempValue = 0;
                }
                temp.put(tempWord, tempValue + 1);
                right += wordLength;
                tempArrLength++;
            } else {
                //如果map中不存在这个字符串就将left++并将left赋给right
                left++;
                right = left;
                tempArrLength = 0;
                temp.clear();
            }
            //如果temp的map添加的数量与words的数量一致就证明，此次循环的单词与words中的一致。
            //然后left++ 并将left赋给right
            if (tempArrLength == arrLength) {
                ans.add(left);
                left++;
                right = left;
                tempArrLength = 0;
                temp.clear();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "barfoothedfoobarman";
//        String words[] = {"foo","bar"};
        String s = "";
        String words[] = {};
        List<Integer> substring = new SubstringWithConcatenationofAllWords().findSubstring(s, words);
        for (int i = 0; i < substring.size(); i++) {
            System.out.println(substring.get(i));
        }
    }
}
