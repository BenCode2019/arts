/**
 * 48. Rotate Image
 * Created by mengwei on 2019/8/19.
 */
public class RotateImage {

    /**
     * 方法 1 ：转置加翻转最直接的想法是先转置矩阵，然后翻转每一行。
     * 转置可以想像成在纸的正面写好矩阵，然后手拿着向上翻过来看背面。
     * 翻转就是倒叙一下每一行。
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        printMatrix(matrix);
        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        printMatrix(matrix);
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
        printMatrix(matrix);
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int counts = n / 2 + n % 2;
        printMatrix(matrix);
        for (int i = 0; i < counts; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                printMatrix(matrix);
            }
        }
    }

    private void printMatrix(int[][] matrix){
        System.out.println("");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new RotateImage().rotate2(matrix);
    }
}
