import java.util.Scanner;

class Main {
    static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String choice;

        Boarder gameBoard = new Boarder();

        do{
            System.out.println("\n Hello players");
            System.out.println("Welcome to the tic-tac-toe!");
            System.out.println("1-Add player");
            System.out.println("2-Show table");
            System.out.println("3-End");
            System.out.print("Your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1 -> {
                    initializePlayers(scanner);
                }
                case 2 -> {
                    if (gameBoard != null) {
                        System.out.println("\nCurrent game board:");
                        gameBoard.showInfo();
                    } else {
                        System.out.println("Board not initialized!");
                    }
                }
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            choice = scanner.next();
            scanner.nextLine();

        } while (choice.equalsIgnoreCase("y"));
        System.out.println("Program finished.");
        scanner.close();
    }

    private static void initializePlayers(Scanner scanner) {
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
    }
}