/**
 *
 * 将数字转换为罗马数字，罗马数字几个字母表示的数字为：
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 100 C 200 CC 300 CCC 400 CD 500 D 600 DC 700 DCC 800 DCCC 900 CM
 * 可以看出来100 - 300是一类， 400 是一类 ，500 - 800是一类 ，900是一类。
 * 参考：https://www.cnblogs.com/grandyang/p/4123374.html
 *
 * Created by mengwei on 2019/4/17.
 */
public class IntegertoRoman {

    public String intToRoman(int num) {
        char[] s = {'M','D','C','L','X','V','I'};
        int[] v =  {1000,500,100,50,10,5,1};
        String rs = "";
        for(int i = 0;i < 7;i += 2){
            int value = v[i];
            int r = num / value;
            if(r < 4){
                for(int j = 0;j < r;j++){
                    rs += s[i];
                }
            }
            if(r == 4){
                rs = rs + s[i] + s[i-1];
            }
            if(r == 9){
                rs = rs + s[i] + s[i-2];
            }
            if(r > 4 && r < 9){
                rs += s[i-1];
                for(int j = 6; j <= r;j++){
                    rs += s[i];
                }
            }
            num = num % value;
        }
        return rs;
    }

    public static void main(String[] args) {
        int num = 400;
        num = num / 1000;
        System.out.println("args = [" + num + "]");

        String s = new IntegertoRoman().intToRoman(3);
        System.out.println("args = [" + s + "]");

        String s1 = new IntegertoRoman().intToRoman(4);
        System.out.println("args = [" + s1 + "]");

        String s2 = new IntegertoRoman().intToRoman(9);
        System.out.println("args = [" + s2 + "]");

        String s3 = new IntegertoRoman().intToRoman(58);
        System.out.println("args = [" + s3 + "]");

        String s4 = new IntegertoRoman().intToRoman(1994);
        System.out.println("args = [" + s4 + "]");
    }
}
