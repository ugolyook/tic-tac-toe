import java.util.Scanner;

class Main {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        String choice;
        Boarder gameBoard = null;

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
                    Gamer gamer = new Gamer();

                    System.out.print("Enter 1 gamers name: ");
                    gamer.setName_1(scanner.nextLine());

                    System.out.print("Enter 1 gamers simbol(x/o): ");
                    gamer.setSimbol_1(scanner.nextLine());

                    System.out.print("Enter 2 gamers name: ");
                    gamer.setName_2(scanner.nextLine());

                    System.out.print("Enter 2 gamers simbol(x/o): ");
                    gamer.setSimbol_2(scanner.nextLine());

                    if (gameBoard == null){
                        gameBoard = new Boarder();
                    }

                    System.out.println("Initial data");
                    gamer.showInfo();
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
}