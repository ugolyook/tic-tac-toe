import java.util.Scanner; //check

class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = null;
        FileManager file = new FileManager();

        greetings();
        do {
            System.out.print("Your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    Player gamer1 = initializePlayers(scanner);
                    Player gamer2 = initializePlayers(scanner);
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
            gameBoard.toString();
        } else {
            System.out.println("Board not initialized!");
        }
    }

    private static Player initializePlayers(Scanner scanner) {                          //ConsoleRunner
        Player gamer = new Player();

        System.out.print("Enter gamer name: ");
        gamer.setName(scanner.nextLine().toLowerCase());

        System.out.print("Enter gamer simbol(x/o): ");
        String input = scanner.nextLine().trim();

        char simbol = symbolValidator(input, scanner);
        gamer.setSimbol(simbol);

        System.out.println("Initial data");
        String data = gamer.toString();
        System.out.println("Players:" + data);
        return gamer;
    }

    private static char symbolValidator(String input, Scanner scanner) {
        if ((input.length() != 1) || (input.charAt(0) != 'x' && input.charAt(0) != 'o')) {
            System.out.println("\nTry again...");
            System.out.print("\nEnter gamer simbol (x/o): ");
            input = scanner.nextLine().trim();

            return symbolValidator(input, scanner);
        } else {
            return input.charAt(0);
        }
    }
}