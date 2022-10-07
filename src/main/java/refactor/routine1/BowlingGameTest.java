package refactor.routine1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mengwei
 * @version 1.0.0
 * @ClassName BowlingGameTest.java
 * @Description TODO
 * @createTime 2022年10月05日
 * @updateBy mengwei
 * @updateTime $ 15:12$ $
 */
public class BowlingGameTest {

    @Test
    public void test_all_gutters(){
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.throwBow(0);
        }
        assertEquals(0,game.score);
    }

    @Test
    public void test_all_ones(){
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.throwBow(1);
        }
        game.calculateScore();
        assertEquals(20,game.score);
    }

    @Test
    public void test_different_thows(){
        BowlingGame game = new BowlingGame();
        game.throwBow(6);
        game.throwBow(0);
        game.throwBow(7);
        game.throwBow(0);
        game.throwBow(2);
        for (int i = 0; i < 15; i++) {
            game.throwBow(0);
        }
        game.calculateScore();
        assertEquals(game.score,15);
    }

    @Test
    public void test_for_spare(){
        BowlingGame game = new BowlingGame();
        game.throwBow(4);
        game.throwBow(6);
        game.throwBow(7);
        game.throwBow(0);
        for (int i = 0; i < 16; i++) {
            game.throwBow(0);
        }
        game.calculateScore();
        assertEquals(24,game.score);
    }
}
