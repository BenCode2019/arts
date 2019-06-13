import java.util.LinkedList;
import java.util.List;

/**
 * https://blog.csdn.net/qustmeng/article/details/52186378?locationNum=4&fps=1
 * https://wiki.mbalib.com/wiki/%E4%BA%8C%E6%AC%A1%E6%8C%87%E6%95%B0%E5%B9%B3%E6%BB%91%E6%B3%95
 *
 * Created by mengwei on 2019/6/12.
 */
public class SecondExponentialSmoothingMethod {

    /**
     * 二次指数平滑法求预测值
     * @param list 基础数据集合
     * @param year 未来第几期
     * @param modulus 平滑系数
     * @return 预测值
     */
    private static Double getExpect(List<Double> list, int year, Double modulus ) {
        if (list.size() < 10 || modulus <= 0 || modulus >= 1) {
            return null;
        }
        Double modulusLeft = 1 - modulus;
        Double lastIndex = list.get(0);
        Double lastSecIndex = list.get(0);
        for (Double data :list) {
            lastIndex = modulus * data + modulusLeft * lastIndex;
            lastSecIndex = modulus * lastIndex + modulusLeft * lastSecIndex;
        }
        Double a = 2 * lastIndex - lastSecIndex;
        Double b = (modulus / modulusLeft) * (lastIndex - lastSecIndex);
        return a + b * year;
    }

    public static void main(String[] args) {
        List<Double> list = new LinkedList<Double>();
        list.add(253993d);
        list.add(289665d);
        list.add(342785d);
        list.add(384763d);
        list.add(428964d);
        list.add(470614d);
        list.add(530217d);
        list.add(620206d);
        list.add(688212d);
        list.add(746422d);
        list.add(809592d);
        list.add(791376d);
        list.add(772682d);
        list.add(806048d);
        list.add(860855d);
        list.add(996633d);
        list.add(1092883d);
        list.add(1172596d);
        list.add(1245356d);
        list.add(1326094d);
        list.add(1378717d);
        list.add(1394413d);
        list.add(1478573d);
        list.add(1534122d);
        list.add(1608150d);
        Double value = getExpect(list, 4, 0.6);
        System.out.println(value);
    }
}
