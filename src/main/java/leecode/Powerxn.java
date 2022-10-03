/**
 * 直接模拟该过程，将 x 连乘 n 次。
 * 如果 n < 0，我们可以用1/x
 * −n 代替 x, nx,n 来保证 n \ge 0n≥0 。这个限制可以简化我们下面的讨论。
 * A = x^n/2
 * if x % 2 =0 { A * A = x ^ n }
 * else { A * A * x = x ^ n }
 * 所以采用递归的形式
 * Created by mengwei on 2019/8/28.
 */
public class Powerxn {

    /**
     *              A = x^n/2
     * if x % 2 =0  { A * A = x ^ n }
     * else         { A * A * x = x ^ n }
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public static void main(String[] args) {
        double v = new Powerxn().myPow(2, -4);
        System.out.println(v);
    }
}
