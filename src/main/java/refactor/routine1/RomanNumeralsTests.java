package refactor.routine1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1000    M
 * 500     D
 * 100     C
 * 50      L
 * 10      X
 * 5,      V
 * 1，     I
 * @author mengwei
 * @version 1.0.0
 * @ClassName FizzBuzzTests.java
 * @Description TODO
 * @createTime 2022年10月03日
 * @updateBy mengwei
 * @updateTime $ 20:08$ $
 */
public class RomanNumeralsTests {

    private String convert(int number){
        String roman = "";
        Integer[] arabic_numberals = {10,5,1};
        String[] roman_numberals = {"X","V","I"};
        for (int i = 0; i < arabic_numberals.length; i++) {
            while(number >= arabic_numberals[i]){
                roman += roman_numberals[i];
                number -= arabic_numberals[i] ;
            }
        }
        return roman;
    }
    @Test
    public void testFizzbuzz(){
        assertEquals(convert(1),"I");
        assertEquals(convert(2),"II");
        assertEquals(convert(3),"III");
        assertEquals(convert(5),"V");
        assertEquals(convert(10),"X");
        assertEquals(convert(20),"XX");
        assertEquals(convert(30),"XXX");
    }
}
