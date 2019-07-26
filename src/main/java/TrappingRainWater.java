/**
 * 42. Trapping Rain Water
 * 有四种方法
 * 1 暴力法
 * 2 将left max和right max存起来
 * 3 采用栈的方式
 * 4 采用左右指针的方式
 * Created by mengwei on 2019/7/23.
 */
public class TrappingRainWater {


    /**
     * 暴力法
     * 1 初始化ans
     * 2 从左向右扫描数组
     *   从当前元素向左扫描找出最高的
     *   从当前元素向右扫描找出最高的
     *   将找到最面最高的和右面最高的，取最低的那个再减去当前元素的高度
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    /**
     * 1 找到数组中最左端最高的条形块高度
     * 2 找到数组中最右端最高的条形块高度
     * 3 扫描height数组找到min(left,right) - height再累加
     * left : 0 1 1 2 2 2 2 3 3 3 3 3
     * right: 3 3 3 3 3 3 3 3 2 2 2 0
     * min(left,right):1 1 2 2 2 2 3 2 2 2
     * height:         1 0 2 1 0 1 3 2 1 2
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int ans = 0;
        int size = height.length;
        if(size <= 0){
            return 0;
        }
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];
        maxleft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxleft[i] = Math.max(maxleft[i - 1], height[i]);
        }
        for (int i = 0; i < maxleft.length; i++) {
            System.out.print(" " + maxleft[i]);
        }

        maxright[size - 1] = height[size - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            maxright[j] = Math.max(maxright[j + 1], height[j]);
        }
        System.out.println("");
        for (int i = 0; i < maxright.length; i++) {
            System.out.print(" " + maxright[i]);
        }
        System.out.println("");

        for (int i = 1; i < size - 1; i++) {
            System.out.print(" " + Math.min(maxleft[i], maxright[i]));
        }System.out.println("");

        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(maxleft[i], maxright[i]) - height[i];
            System.out.print(" " + height[i]);
        }
        System.out.println("");
        return ans;
    }

    /**
     * 左右指针的方法
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        int ans = 0;
        while(left < right){
            int leftval = height[left];
            int rightval = height[right];
            if(leftval < rightval){
                if(leftval >= leftmax){
                    leftmax = leftval;
                }else{
                    ans += (leftmax - leftval);
                }
                left++;
            }else{
                if(rightval >= rightmax){
                    rightmax = rightval;
                }else{
                    ans += (rightmax - rightval);
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] rs = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] rs = new int[]{2,0,2};
        int[] rs = new int[]{};
        int water = new TrappingRainWater().trap3(rs);
        System.out.println("args = [" + water + "]");
    }

}
