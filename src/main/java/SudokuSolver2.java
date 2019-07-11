/**
 * 37. Sudoku Solver
 * 采用回溯法
 * 用两个方法递归是因为要判断当走到最后一个列时如果没有走完要删除当前节点进行回溯。否则就要用到return
 * Created by mengwei on 2019/7/5.
 */
public class SudokuSolver2 {

    // box size
    int n = 3;
    // row size
    int N = n * n;

    int [][] rows = new int[N][N + 1];
    int [][] columns = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
        /*
            Check if one could place a number d in (row, col) cell
        */
        int idx = (row / n ) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
        /*
            Place a number d in (row, col) cell
        */
        int idx = (row / n ) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }

    public void removeNumber(int d, int row, int col) {
        /*
            Remove a number which didn't lead to a solution
        */
        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        sloveDFS(0, 0);
    }

    public void recursionNextNumbersDFS(int row, int col) {
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        } else {
            if (col == N - 1) {
                sloveDFS(row + 1, 0);
            }
            else {
                sloveDFS(row, col + 1);
            }
        }
    }

    /**
     * 用两个方法递归是因为要判断当走到最后一个列时如果没有走完要删除当前节点进行回溯。否则就要用到return
     * @param row
     * @param col
     */
    private void sloveDFS(int row, int col) {
        if(board[row][col] == '.'){
            for (int value = 1; value < 10; value++) {
                if(couldPlace(value,row,col)){
                    placeNumber(value,row,col);
                    recursionNextNumbersDFS(row,col);
                    if(!sudokuSolved){
                        removeNumber(value,row,col);
                    }
                }
            }
        }else{
            recursionNextNumbersDFS(row,col);
        }
    }

    public static void main(String[] args) {
        char[][] boards = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        new SudokuSolver2().solveSudoku(boards);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("[" + boards[i][j] + "]");
            }
            System.out.println();
        }
    }
}
