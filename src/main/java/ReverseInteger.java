/**
 * 可以使用 n % 10来取最小位的数
 * 使用n / 10来去掉最小位的数
 * 要注意判断rs最后的边界，不能大于Integer的最大值和小于最小值。
 * 使用Long是因为需要能存储超过Integer的值。
 * Created by mengwei on 2019/3/27.
 */
public class ReverseInteger {
    public int reverse(int n) {
        long rs = 0;
        while(n != 0){
            rs = rs * 10 + n % 10;
            n = n / 10;
            if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE){
                return 0;
            }
        }
        return Integer.valueOf(String.valueOf(rs));
    }

    public static void main(String[] args) {
        System.out.println(321 % 10);
        System.out.println(4 / 10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int reverse = new ReverseInteger().reverse(1234567892);
        System.out.println(reverse);
    }
}
