public class Boarder
{
    private char[][] matrix;

    public Boarder() {
        matrix = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = '*';
            }
        }
    }

    public void showInfo() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

