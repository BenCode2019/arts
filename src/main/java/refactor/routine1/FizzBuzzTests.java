package refactor.routine1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mengwei
 * @version 1.0.0
 * @ClassName FizzBuzzTests.java
 * @Description TODO
 * @createTime 2022年10月03日
 * @updateBy mengwei
 * @updateTime $ 20:08$ $
 */
public class FizzBuzzTests {

    @Test
    public void testFizzbuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals(fizzBuzz.fizzbuzz(1),"1");
        assertEquals(fizzBuzz.fizzbuzz(0),"0");
        assertEquals(fizzBuzz.fizzbuzz(3),"fizz");
        assertEquals(fizzBuzz.fizzbuzz(5),"buzz");
        assertEquals(fizzBuzz.fizzbuzz(15),"fizzbuzz");
    }
}
