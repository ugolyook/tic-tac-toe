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

    public void winnerCheck() {
        if (matrix[0][0] == 'x' && matrix[0][1] == 'x' && matrix[0][2] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }
        if (matrix[1][0] == 'x' && matrix[1][1] == 'x' && matrix[1][2] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }
        if (matrix[2][0] == 'x' && matrix[2][1] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }
        if (matrix[0][0] == 'x' && matrix[1][0] == 'x' && matrix[2][0] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }
        if (matrix[0][1] == 'x' && matrix[1][1] == 'x' && matrix[2][1] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }
        if (matrix[0][2] == 'x' && matrix[1][2] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }
        if (matrix[0][0] == 'x' && matrix[1][1] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }
        if (matrix[0][2] == 'x' && matrix[1][1] == 'x' && matrix[2][0] == 'x') {
            System.out.println("\n X is winner!!!");
            return;
        }


        if (matrix[0][0] == 'o' && matrix[0][1] == 'o' && matrix[0][2] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }
        if (matrix[1][0] == 'o' && matrix[1][1] == 'o' && matrix[1][2] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }
        if (matrix[2][0] == 'o' && matrix[2][1] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }
        if (matrix[0][0] == 'o' && matrix[1][0] == 'o' && matrix[2][0] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }
        if (matrix[0][1] == 'o' && matrix[1][1] == 'o' && matrix[2][1] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }
        if (matrix[0][2] == 'o' && matrix[1][2] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }

        if (matrix[0][0] == 'o' && matrix[1][1] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }
        if (matrix[0][2] == 'o' && matrix[1][1] == 'o' && matrix[2][0] == 'o') {
            System.out.println("\n O is winner!!!");
            return;
        }

        System.out.println("\n No winner yet...");
    }
}



