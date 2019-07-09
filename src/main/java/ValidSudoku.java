import java.util.HashSet;
import java.util.Set;

/**
 * 36 Valid Sudoku
 * 原理参考 https://blog.csdn.net/grape875499765/article/details/78274332
 * 实现参考 https://blog.csdn.net/mine_song/article/details/70207326
 * Created by mengwei on 2019/7/4.
 */
public class ValidSudoku {

    /**
     * 主要是注意子九宫格的行和列坐标 3 * (i / 3) + j / 3;
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9 ;i++){
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9 ; j++) {
                if(board[i][j] != '.' && !row.add(board[i][j])){
                    return false;
                }
                if(board[j][i] != '.' && !col.add(board[j][i])){
                    return false;
                }
                // 行号+偏移量
                int rowIndex = 3 * (i / 3) + j / 3;
                // 列号+偏移量
                int colIndex = 3 * (i % 3) + j % 3;
                if(board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] boards = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        boolean validSudoku = new ValidSudoku().isValidSudoku(boards);
        System.out.println("args = [" + validSudoku + "]");
    }
}
