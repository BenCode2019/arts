/**
 * 将一个字符串改为之字的排序
 * 参考: https://www.cnblogs.com/springfor/p/3889414.html
 * Created by mengwei on 2019/3/27.
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        if(s == null || s.length()==0 || nRows <=0)
            return "";
        if(nRows == 1)
            return s;

        StringBuilder res = new StringBuilder();
        int size = 2*nRows-2;
        for(int i=0;i<nRows;i++){
            //j的跨度为 2 * n - 2
            for(int j=i;j<s.length();j+=size){
                res.append(s.charAt(j));
                //except the first row and the last row
                //行首和行尾没有中间层
                if(i != 0 && i != nRows - 1){
                    //中间跨度为 j + (2 * n - 2) - 2 * i
                    int temp = j+size-2*i;
                    if(temp<s.length())
                        res.append(s.charAt(temp));
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String convert = new ZigZagConversion().convert(s, 3);
        System.out.println(convert);
    }
}
