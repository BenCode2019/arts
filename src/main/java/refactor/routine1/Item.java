package refactor.routine1;

/**
 * @author mengwei
 * @version 1.0.0
 * @ClassName Item.java
 * @Description TODO
 * @createTime 2022年10月07日
 * @updateBy mengwei
 * @updateTime $ 15:40$ $
 */

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
