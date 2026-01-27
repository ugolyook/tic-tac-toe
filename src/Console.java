import java.util.Scanner;

public class Console {
    private final Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public static void playConsole(String playerName) {
        System.out.println("\nPlayer:" + playerName + " give your choice:");
    }

    public static void isDrawConsole() {
        System.out.println("You have a draw!");
    }

    public int[] playerMoveConsole(String playerName, char[][] board) {

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
            if (i >= 0 && i < board.length && j >= 0 && j < board.length) {
                if (board[i][j] == '*') {
                    break;
                } else {
                    System.out.println("Cell is already occupied! Choose another one.");
                }
            } else {
                System.out.println("Coordinates must be between 0 and 2!");
            }
        }

        return new int[]{i, j};
    }

    public static void isWinnerFoundConsole(char winnerSimbol) {

        System.out.println("\n" + winnerSimbol + " is winner");

    }
}
