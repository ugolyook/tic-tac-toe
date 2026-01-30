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
                    Player gamer1 = ConsoleRunner.initializePlayers(scanner);
                    Player gamer2 = ConsoleRunner.initializePlayers(scanner);
                    gameBoard = new GameBoard(gamer1, gamer2);
                }
                case 2 -> {
                    printBoard(gameBoard);
                }
                case 3 -> {
                    ConsoleRunner consoleRunner = new ConsoleRunner(gameBoard);
                    System.out.println("Let start game:");
                    consoleRunner.play();
                    greetings();
                }
                case 4 -> {
                    GameResultDto dto = gameBoard.toGameResault();
                    FileManager.saveData(dto);
                }
                case 5 -> {
                    FileManager.readData();
                }
                case 6 -> {
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
        System.out.println("1-Add player");
        System.out.println("2-Show table");
        System.out.println("3-Start game");
        System.out.println("4-Save data");
        System.out.println("5-Read data");
        System.out.println("6-End");
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