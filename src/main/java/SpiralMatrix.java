import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Created by mengwei on 2019/9/4.
 */
public class SpiralMatrix {

    /**
     * seen[r][c] 表示第 r 行第 c 列的单元格之前已经被访问过了。
     * 当前所在位置为 (r, c)，前进方向是 di。
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) {
            return ans;
        }
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        /**
         * dr表示行的方向，当行往下移动，列为0表示不动
         * dc表示列的方向，当列往右移动，行为0表示不动
         *         -1[4]
         *   -1[3]       1[1]
         *         1[2]
         *   从右往左顺时针循环[1,1,-1,-1]
         */
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                // 由于dr和dr分别有四组数字，所以取4的余数，每次+1表示下次调转方向。
                // 如果是向外螺旋可以将数组顺序颠倒
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = new SpiralMatrix().spiralOrder(matrix);
        for (Integer i :integers) {
            System.out.print(i);
        }
    }

}
