import java.util.Scanner;

class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice;
        int y = 0;

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
                    Player gamer = initializePlayers(scanner);
                    gameBoard = new Boarder(
                            gamer.getName1(),
                            gamer.getName2(),
                            gamer.getSimbol1().charAt(0),
                            gamer.getSimbol2().charAt(0)
                    );
                }
                case 2 -> {
                    if (gameBoard != null) {
                        System.out.println("\nCurrent game board:");
                        gameBoard.showInfo();
                    } else {
                        System.out.println("Board not initialized!");
                    }
                }
                case 3 -> {
                    if (gameBoard != null) {
                        System.out.println("\nCurrent game board:");
                        gameBoard.showInfo();
                        gameBoard.play();
                    } else {
                        System.out.println("Board not initialized!");
                    }
                }
                case 4 -> {
                    System.out.println("Program finished.");
                    scanner.close();
                    return;
                }
            }
        }
        while (y != 2);
        System.out.println("Program finished.");
        scanner.close();

    }

    private static Player initializePlayers(Scanner scanner) {
        Player gamer = new Player();

        System.out.print("Enter 1 gamers name: ");
        gamer.setName1(scanner.nextLine());

        System.out.print("Enter 1 gamers simbol(x/o): ");
        gamer.setSimbol1(scanner.nextLine());

        System.out.print("Enter 2 gamers name: ");
        gamer.setName2(scanner.nextLine());

        System.out.print("Enter 2 gamers simbol(x/o): ");
        gamer.setSimbol2(scanner.nextLine());

        System.out.println("Initial data");
        gamer.showInfo();
        return gamer;
    }
}