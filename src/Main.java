import java.util.Scanner;

class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Boarder gameBoard = null;
        Player players = null;

        System.out.println("\n Hello players");
        System.out.println("Welcome to the tic-tac-toe!");
        System.out.println("1-Add player");
        System.out.println("2-Show table");
        System.out.println("3-Start game");
        System.out.println("4-End");

        do {
            System.out.print("Your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    Player gamer1 = initializePlayers(scanner);//1 player
                    Player gamer2 = initializePlayers(scanner);//2 player
                    gameBoard = new Boarder(gamer1, gamer2);
                }
                case 2 -> {
                    boardChecker(gameBoard);
                }
                case 3 -> {
                    boardChecker(gameBoard);
                    gameBoard.play();
                }
                case 4 -> {
                    System.out.println("Program finished.");
                    scanner.close();
                    return;
                }
            }
        }
        while (true);
    }

    //method
    private static void boardChecker(Boarder gameBoard) {
        if (gameBoard != null) {
            System.out.println("\nCurrent game board:");
            gameBoard.showInfo();
        } else {
            System.out.println("Board not initialized!");
        }
    }

    private static Player initializePlayers(Scanner scanner) {//check for char
        Player gamer = new Player();

        System.out.print("Enter gamer name: ");
        gamer.setName(scanner.nextLine().toLowerCase());

        System.out.print("Enter gamer simbol(x/o): ");
        String input = scanner.nextLine().trim();

        gamer.simbol = lengthChecker(input, scanner);

        if (gamer.simbol != 'x' && gamer.simbol != 'o') { //1 method
            System.out.println("\nTry again (x/o):");
            input = scanner.nextLine().trim();
            gamer.simbol = lengthChecker(input, scanner);
        }

        System.out.println("Initial data");
        gamer.showInfo();
        return gamer;
    }

    private static char lengthChecker(String input, Scanner scanner) {//1 method
        if (input.length() != 1) {
            System.out.println("\nTry again...");
            System.out.print("\nEnter gamer simbol(x/o): ");
            input = scanner.nextLine().trim();

            return lengthChecker(input, scanner);
        } else {
            return input.charAt(0);
        }
    }
}