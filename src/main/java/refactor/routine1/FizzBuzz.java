package refactor.routine1;

/**
 * @author mengwei
 * @version 1.0.0
 * @ClassName FizzBuzz.java
 * @Description TODO
 * @createTime 2022年10月03日
 * @updateBy mengwei
 * @updateTime $ 20:12$ $
 */
public class FizzBuzz {

    public String fizzbuzz(int number){
        if(number == 0){
            return "0";
        }
        if(number % 3 == 0 && number % 5 == 0){
            return "fizz"+"buzz";
        }
        if(number % 3 == 0){
            return "fizz";
        }
        if(number % 5 == 0){
            return "buzz";
        }

        return String.valueOf(number);
    }
}
