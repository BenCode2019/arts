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
public class FizzBuzzVersionTwo {

    public String fizzbuzz(int number){
        if(number == 0){
            return "0";
        }
        if(divideThreeMode(number) && divideFiveMode(number)){
            return "fizz"+"buzz";
        }
        if(divideThreeMode(number)){
            return "fizz";
        }
        if(divideFiveMode(number)){
            return "buzz";
        }
        return String.valueOf(number);
    }

    private boolean divideThreeMode(int number){
        return number % 3 == 0;
    }
    private boolean divideFiveMode(int number){
        return number % 5 == 0;
    }
}
