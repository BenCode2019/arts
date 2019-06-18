/**
 * sum是将除数相加的值
 * pow是相加的次数也就是倍数。最后返回pow
 * 参考:https://blog.csdn.net/perfect8886/article/details/23040143
 * Created by mengwei on 2019/6/16.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        //handle special cases
        if(divisor==0) {
            return Integer.MAX_VALUE;
        }
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        //get positive values
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int result = 0;
        while(pDividend>=pDivisor){
            //calculate number of left shifts
            int numShift = 0;
            while(pDividend>=(pDivisor<<numShift)){
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }

        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }else{
            return -result;
        }
    }

    public int divide2(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        boolean isNeg = (dividend > 0 && divisor < 0)
                || (dividend < 0 && divisor > 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        if (b > a) {
            return 0;
        }

        long sum = 0;
        long pow = 0;
        int result = 0;
        while (a >= b) {
            pow = 1;
            sum = b;
            while (sum + sum <= a) {
                sum += sum;
                pow += pow;
            }
            a -= sum;
            result += pow;
        }
        return isNeg ? -result : result;
    }

    public static void main(String[] args) {
        int divide = new DivideTwoIntegers().divide(-2147483648, -1);
        System.out.println(divide);
    }

}
