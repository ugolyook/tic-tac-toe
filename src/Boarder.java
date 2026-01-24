import java.util.Scanner;

public class Boarder {
    private final char[][] matrix;
    private final Scanner scanner;
    private final Player player1;
    private final Player player2;

    public Boarder(Player player1, Player player2) {
        this.scanner = new Scanner(System.in);
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

    public void play() {
        System.out.println("Let start game:");
        initializeBoard();
        showInfo();
        int maxMoveNumbers = (matrix.length * matrix.length);

        for (int moveNumber = 0; moveNumber < maxMoveNumbers; moveNumber += 2) {
            System.out.println("Move:" + (moveNumber + 1) + "\nPlayer:" + player1.getName() + " give your choice:");
            playerMove(player1.getName(), player1.getSimbol());

            if (winnerCheck()) return;

            if (moveNumber + 1 == maxMoveNumbers) {
                System.out.println("You have a draw!");
                return;
            }

            System.out.println("Move:" + (moveNumber + 2) + "\nPlayer:" + player2.getName() + " give your chose:");
            playerMove(player2.getName(), player2.getSimbol());
            if (winnerCheck()) return;
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

    public boolean winnerCheck() {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 'x' & matrix[i][1] == 'x' & matrix[i][2] == 'x') {
                System.out.println("\nX is winner");
                return true;
            }
            if (matrix[i][0] == 'o' & matrix[i][1] == 'o' & matrix[i][2] == '0') {
                System.out.println("\nO is winner");
                return true;
            }

            if (matrix[0][i] == 'x' & matrix[1][i] == 'x' & matrix[2][i] == 'x') {
                System.out.println("\nX is winner");
                return true;
            }
            if (matrix[0][i] == 'o' & matrix[1][i] == 'o' & matrix[2][i] == 'o') {
                System.out.println("\nO is winner");
                return true;
            }

        }
        if (matrix[0][0] == 'x' & matrix[1][1] == 'x' & matrix[2][2] == 'x') {
            System.out.println("\nX is winner");
            return true;
        }
        if (matrix[0][2] == 'x' & matrix[1][1] == 'x' & matrix[2][0] == 'x') {
            System.out.println("\nX is winner");
            return true;
        }

        if (matrix[0][0] == 'o' & matrix[1][1] == 'o' & matrix[2][2] == 'o') {
            System.out.println("\nO is winner");
            return true;
        }
        if (matrix[0][2] == 'o' & matrix[1][1] == 'o' & matrix[2][0] == 'o') {
            System.out.println("\nO is winner");
            return true;
        }

        return false;
    }

}




