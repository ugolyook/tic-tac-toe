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
                    Player gamer1 = initializePlayers(scanner);//2 player
                    Player gamer2 = initializePlayers(scanner);//2 player
                    gameBoard = new Boarder(gamer1,gamer2);
                }
                case 2 -> {
                    if (gameBoard != null) { //method
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
        while (true);
    }

    private static Player initializePlayers(Scanner scanner) {//cheack for char
        Player gamer = new Player();

        System.out.print("Enter 1 gamers name: ");
        gamer.setName(scanner.nextLine());

        System.out.print("Enter 1 gamers simbol(x/o): ");
        gamer.setSimbol(scanner.nextLine().charAt(0));

        System.out.print("Enter 2 gamers name: ");
        gamer.setName2(scanner.nextLine());

        System.out.print("Enter 2 gamers simbol(x/o): ");
        gamer.setSimbol2(scanner.nextLine().charAt(0));//simbol(string size == 1)

        System.out.println("Initial data");
        gamer.showInfo();
        return gamer;
    }
}