import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * Created by mengwei on 2019/9/2.
 */
public class NQueens {

    int cols[];
    int n = 0;
    int hills[];
    int dales[];
    int queens[];
    List<List<String>> output = new ArrayList();

    /**
     * 1 循环列 判断是否被攻击
     * 2 如果不被攻击 就放置queen
     * 3 如果n + 1 == row表示所有行都检索了一边，就将该方案添加进output中
     * 4 否则进行回溯
     * 5 将当前queen删除
     * @param row
     */

    private void backtrace(int row){
        for (int col = 0; col < n; col++) {
            // 1
            if(isAttack(row,col)){
                // 2
                placeQueen(row,col);
                // 3
                if(row + 1 == n){
                    addResolveNQueens();
                }else{
                    // 4
                    backtrace(row+1);
                }
                // 5
                removeQueen(row,col);
            }
        }
    }

    private boolean isAttack(int row, int col) {
        int res = cols[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    private void placeQueen(int row, int col) {
        queens[row] = col;
        cols[col] = 1;
        hills[row - col + 2 * n] = 1;
        dales[row + col] = 1;
    }

    private void addResolveNQueens() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int currentQueen = queens[i];
            for(int j = 0;j < currentQueen;j++){
                sb.append(".");
            }
            sb.append("Q");
            int f = n - currentQueen;
            for(int j = 0;j < f - 1;j++){
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    private void removeQueen(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrace(0);
        return output;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new NQueens().solveNQueens(4);
        for (List<String> rs:lists) {
            for (String s:rs) {
                System.out.println(s);
            }
            System.out.println("");
        }
    }
}
