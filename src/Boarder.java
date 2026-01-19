import java.util.Scanner;

public class Boarder {
    private char[][] matrix;
    private int move;
    private Scanner scanner;
    private Player player1;
    private Player player2;

    public Boarder(Player player1, Player player2) {
        this.scanner = new Scanner(System.in);
        this.move = 0;
        matrix = new char[3][3];
        initializeBoard();
        this.player1 = player1;
        this.player2 = player2;
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

    //fix
    public void play() {
        System.out.println("Let start game:");
        move = 0;
        initializeBoard();
        showInfo();
        int moveNumber = (matrix.length * matrix.length);

        for (int moveCount = 0; moveCount < moveNumber; moveCount++) {
            System.out.println("Move:" + (move + 1) + "\nPlayer:" + player1.getName() + " give your choise:");
            playerMove(player1.getName(), player1.getSimbol());
            move++;

            if (winnerCheck()) return;

            if (move < moveNumber) {
                System.out.println("Move:" + (move + 1) + "\nPlayer:" + player2.getName() + " give your choise:");
                playerMove(player2.getName(), player2.getSimbol());
                move++;
                if (winnerCheck()) return;
            }
        }
    }

    public void playerMove(String playerName, char playerSimbol) {

        System.out.println("\nPlayer:" + playerName + " Make your move: ");
        int i = -1, j = -1;
        while (true) {
            System.out.print("\nEnter your i (0-2): ");
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.print("\nEnter your j (0-2): ");
            if (scanner.hasNextInt()) {
                j = scanner.nextInt();
                scanner.nextLine();
            }
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix.length) {
                if (matrix[i][j] == '*') {
                    matrix[i][j] = playerSimbol;

                    System.out.println("\nCurrent board:");
                    showInfo();
                    break;
                } else {
                    System.out.println("\nCell is already occupied! Choose another one.");
                }
            } else {
                System.out.println("\nCoordinates must be between 0 and 2!");
            }
        }
    }

    //fix
    public boolean winnerCheck() {
        if (matrix[0][0] == 'x' && matrix[0][1] == 'x' && matrix[0][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[1][0] == 'x' && matrix[1][1] == 'x' && matrix[1][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[2][0] == 'x' && matrix[2][1] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][0] == 'x' && matrix[1][0] == 'x' && matrix[2][0] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][1] == 'x' && matrix[1][1] == 'x' && matrix[2][1] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'x' && matrix[1][2] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][0] == 'x' && matrix[1][1] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'x' && matrix[1][1] == 'x' && matrix[2][0] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }


        if (matrix[0][0] == 'o' && matrix[0][1] == 'o' && matrix[0][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[1][0] == 'o' && matrix[1][1] == 'o' && matrix[1][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[2][0] == 'o' && matrix[2][1] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][0] == 'o' && matrix[1][0] == 'o' && matrix[2][0] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][1] == 'o' && matrix[1][1] == 'o' && matrix[2][1] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'o' && matrix[1][2] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }

        if (matrix[0][0] == 'o' && matrix[1][1] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'o' && matrix[1][1] == 'o' && matrix[2][0] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }

        System.out.println("\nNo winner yet...");
        return false;
    }
}




