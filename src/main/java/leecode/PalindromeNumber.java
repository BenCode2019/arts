/**
 * Created by mengwei on 2019/4/1.
 */
public class PalindromeNumber {

    /**
     * 将所有的位数反转，然后与x比较一样则为回文。
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if(x < 0) return false;
        int palindrome = x;
        int reverse = 0;
        while(palindrome != 0){
            reverse = reverse * 10 + palindrome % 10;
            palindrome = palindrome/10;
        }
        if(reverse == x){
            return true;
        }
        return false;
    }

    /**
     * 采用两个数位从中间往外一层一层的比对的方法。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0)return false;
        int len = getLen(x);
        int middle = len%2;
        if(len < 1){
            return false;
        }
        if(len / 2 != 0){
            //是奇数
            int begin = middle+1;
            int end = middle+1;
            boolean b = scanMatch(x, len, begin, end);
            return b;
        }else{
            //是偶数
            int begin = middle;
            int end = middle+1;
            boolean b = scanMatch(x, len, begin, end);
            return b;
        }
    }

    public boolean scanMatch(int x,int len, int begin,int end){
        while(begin > 0 && end < len+1){
            int s1 = getCurrentNumber(x,begin);
            int s2 = getCurrentNumber(x,end);
            if(s1 != s2){
                return false;
            }
            begin--;
            end++;
        }
        return true;
    }

    /**
     * 获取当前位数的数字，比如123456，取滴4 就是2 。
     * 1 先取当前数位的10的n次方。
     * 2 对x取10的n次方的余数。
     * 3 再除以10的n次方-1。
     * @param x
     * @param currentDigit
     * @return
     */
    public int getCurrentNumber(int x,int currentDigit){
        return (int) (x % Math.pow(10,currentDigit) / Math.pow(10,currentDigit - 1));
    }

    /**
     * 采用递归取当前数的位数的方法。就是不停的除以10。
     * @param x
     * @return
     */
    public int getLen(int x){
        if(x<10) return 1;
        return getLen(x/10)+1;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(10,3));
        int s = 123456;
        System.out.println((int)(s % Math.pow(10,6) / Math.pow(10,5)));
        boolean palindrome = new PalindromeNumber().isPalindrome(21044012);
        System.out.println(palindrome);
        boolean palindrome2 = new PalindromeNumber().isPalindrome2(21044012);
        System.out.println(palindrome2);
        boolean palindrome3 = new PalindromeNumber().isPalindrome(100);
        System.out.println(palindrome3);
        boolean palindrome4 = new PalindromeNumber().isPalindrome(-121);
        System.out.println(palindrome4);

    }
}
