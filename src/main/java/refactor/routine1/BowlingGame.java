package refactor.routine1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengwei
 * @version 1.0.0
 * @ClassName BowlingGame.java
 * @Description TODO
 * @createTime 2022年10月05日
 * @updateBy mengwei
 * @updateTime $ 15:35$ $
 */
public class BowlingGame {

    public int score = 0;
    public List<Integer> throwBows = new ArrayList<>();

    public void throwBow(int pins) {
//        this.score += pins;
        throwBows.add(pins);
    }

    public void calculateScore() {
        int ball = 0;
        for (int i = 0; i < 10; i++) {
            if((this.throwBows.get(ball) + this.throwBows.get(ball+1)) == 10 ){
                this.score += 10 + this.throwBows.get(ball + 2);
            }else{
                this.score += (this.throwBows.get(ball) + this.throwBows.get(ball + 1));
            }
            ball += 2;
        }
    }
}
