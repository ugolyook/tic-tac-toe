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

    public static void isWinnerFoundConsole(char winnerSimbol) {

        System.out.println("\n" + winnerSimbol + " is winner");

    }
}
