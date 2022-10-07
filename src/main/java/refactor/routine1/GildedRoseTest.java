package refactor.routine1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mengwei
 * @version 1.0.0
 * @ClassName GildedRoseTest.java
 * @Description TODO
 * @createTime 2022年10月07日
 * @updateBy mengwei
 * @updateTime $ 16:01$ $
 */

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void test_sulfures(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_sulfures_past_date(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_aged_brie_increases_in_quality(){
        Item[] items = new Item[] { new Item("Aged Brie", 20, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void test_aged_brie_hit_50_quality(){
        Item[] items = new Item[] { new Item("Aged Brie", 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_normal_item_quality(){
        Item[] items = new Item[] { new Item("Rat Soup", 20, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void test_normal_item_degrades_twice_as_fast(){
        Item[] items = new Item[] { new Item("Rat Soup", 0, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void test_normal_item_stop_at_0(){
        Item[] items = new Item[] { new Item("Rat Soup", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_increases_quality(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_stops_at_50_quality(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_less_then_10_days(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);
    }
}
