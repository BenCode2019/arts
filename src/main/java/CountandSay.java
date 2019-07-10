/**
 * 38 Count and Say
 * Created by mengwei on 2019/7/9.
 */
public class CountandSay {

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }

        String str = countAndSay(n - 1) + "*";
        char[] c = str.toCharArray();
        int count = 1;
        String s = "";
        for(int i = 0; i < c.length - 1;i++) {
            if (c[i] == c[i + 1]) {
                count++;//计数增加
            } else {
                s = s + count + c[i];//上面的*标记这里方便统一处理
                count = 1;//初始化
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = new CountandSay().countAndSay(5);
        System.out.println("args = [" + s + "]");
    }
}
