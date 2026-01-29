import java.util.Scanner;

public class ConsoleRunner {
    private final Scanner scanner;
    GameBoard board;

    public ConsoleRunner(GameBoard board) {
        this.scanner = new Scanner(System.in);
        this.board = board;
    }

    public void play() {
        while (!board.isWinnerFound() && !board.isDraw()) {
            int[] move = playerMoveConsole();
            board.move(move[0], move[1]);                                               //new class
        }
        if (board.isWinnerFound()) {
            System.out.println("\n" + board.getWinner() + " is winner\n");
        } else System.out.println("\nIt is draw!\n");
    }

    public int[] playerMoveConsole() {
        int i = -1;
        int j = -1;
        System.out.println("\nPlayer:" + board.getCurrentPlayer() + " Make your move: ");
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
        return new int[]{i, j};
    }

}
