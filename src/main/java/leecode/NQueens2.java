import java.util.ArrayList;
import java.util.List;

/**
 * 52. N-Queens 2
 * Created by mengwei on 2019/9/2.
 */
public class NQueens2 {

    /**
     * 1 循环列 判断是否被攻击
     * 2 如果不被攻击 就放置queen
     * 3 如果n + 1 == row表示所有行都检索了一边，就将该方案添加进output中
     * 4 否则进行回溯
     * 5 将当前queen删除
     * @param row
     */

    private int backtrace(int row,int count,int n,int cols[],int hills[],int dales[]){
        for (int col = 0; col < n; col++) {
            // 1
            int res = cols[col] + hills[row - col + 2 * n] + dales[row + col];
            if((res == 0)){
                // 2
                cols[col] = 1;
                hills[row - col + 2 * n] = 1;
                dales[row + col] = 1;
                // 3
                if(row + 1 == n){
                    count ++;
                }else{
                    // 4
                    count = backtrace(row+1,count,n,cols,hills,dales);
                }
                // 5
                cols[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        int[] cols = new int[n];
        int[] hills = new int[4 * n - 1];
        int[] dales = new int[2 * n - 1];

        return backtrace(0,0,n,cols,hills,dales);
    }

    public static void main(String[] args) {
        int i = new NQueens2().totalNQueens(4);
        System.out.println("args = [" + i + "]");
    }
}
