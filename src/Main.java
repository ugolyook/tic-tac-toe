import java.util.Scanner;

class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = null;

        greetings();
        do {
            System.out.print("Your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {

                case 1 -> {
                    printBoard(gameBoard);
                }
                case 2 -> {
                    ConsoleRunner consoleRunner = new ConsoleRunner(gameBoard);
                    System.out.println("Let start game:");
                    consoleRunner.play();
                    gameBoard=consoleRunner.getBoard();
                    greetings();
                }
                case 3 -> {
                    if (gameBoard != null) {
                        FileManager.saveData(gameBoard.toGameResult());
                    } else {
                        System.out.println("No game to save!");
                    }
                }
                case 4 -> {
                    FileManager.readData();
                }
                case 5 -> {
                    System.out.println("Program finished.");
                    scanner.close();
                    return;
                }
            }
        }
        while (true);
    }

    private static void greetings() {
        System.out.println("Hello players");
        System.out.println("Welcome to the tic-tac-toe!");
        System.out.println("1-Show table");
        System.out.println("2-Start game");
        System.out.println("3-Save data");
        System.out.println("4-Read data");
        System.out.println("5-End");
    }

    private static void printBoard(GameBoard gameBoard) {
        if (gameBoard != null) {
            System.out.println("\nCurrent game board:");
            System.out.println(gameBoard);
        } else {
            System.out.println("Board not initialized!");
        }
    }

}