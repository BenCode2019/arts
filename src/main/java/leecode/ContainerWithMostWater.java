/**
 * 在一条x轴上有n个点，每个点画出一条垂直线，两条直线与x轴构成一个容器，找出能含有最多水的容器。
 * Created by mengwei on 2019/4/12.
 */
public class ContainerWithMostWater {

    /**
     * 采用全局扫一遍的方式，这个算法的复杂度是O(2^n)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int area=0;
        for (int i = 0; i < height.length; i++) {
            for(int j = 0; j < height.length; j++){
                if(j < i){
                    continue;
                }
                int one = height[i];
                int two = height[j];
                if(one < two){
                    int rs = (j - i) * one;
                    if(area < rs){
                        area = rs;
                    }
                }else{
                    int rs = (j - i) * two;
                    if(area < rs){
                        area = rs;
                    }
                }
            }
        }
        return area;
    }

    /**
     * 贪心算法：从两边开始向中间缩小;每一步比较左右边界高度,高度小的那个向里走一步
     * 参考:https://www.cnblogs.com/whu-gbf/p/9173582.html
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int len = right - left;
            if(height[left] < height[right]){
                int rs = height[left] * len;
                if(area < rs){
                    area = rs;
                }
                left++;
            }else{
                int rs = height[right] * len;
                if(area < rs){
                    area = rs;
                }
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] n = {1,8,6,2,5,4,8,3,7};
        int i = new ContainerWithMostWater().maxArea2(n);
        System.out.println(i);
    }

}
