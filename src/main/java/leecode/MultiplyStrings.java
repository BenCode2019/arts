/**
 * 43. Multiply Strings
 * 参考：https://www.cnblogs.com/grandyang/p/4395356.html
 * 写法参考 https://www.programcreek.com/2014/05/leetcode-multiply-strings-java/
 * Created by mengwei on 2019/7/31.
 */
public class MultiplyStrings {

    /**
     *      8 9  <- num2
     *      7 6  <- num1
     * -------
     *      5 4
     *    4 8
     *    6 3
     *  5 6
     * -------
     *  6 7 6 4
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length()+num2.length()];

        //multiply each digit and sum at the corresponding positions
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }
        /**
         * 98 * 99
         * d value :
         *      72
         *    153
         *    81
         *    0
         */
        StringBuilder sb = new StringBuilder();

        //calculate each digit
        /**
         * 98 * 99
         * 72: 2记录到res，7进位
         * 153: 153与进位7相加等于160，0留下来，16进位
         * 81: 81与进位的16相加等于97，7留下来，9进位
         * 0: 0与进位的9相加等于9，9留下来，最后一位不进位
         * 最后得9702
         */
        for(int i = 0; i < d.length; i++){
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if(i+1 < d.length){
                d[i+1] += carry;
            }
            System.out.println(mod);
            sb.insert(0, mod);
        }

        //remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "98";
        String s2 = "99";
        String multiply = new MultiplyStrings().multiply(s1, s2);
        System.out.println(multiply);
    }

}
