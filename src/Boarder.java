import java.util.Scanner;

public class Boarder extends Player {
    private char[][] matrix;
    private int Move;
    private Scanner scanner;

    public Boarder(String name1, String name2, char simbol1,char simbol2) {
        super();
        setName1(name1);
        setName2(name2);
        setSimbol1(String.valueOf(simbol1));
        setSimbol2(String.valueOf(simbol2));
        this.scanner = new Scanner(System.in);
        this.Move = 0;
        matrix = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = '*';
            }
        }
    }

    public void showInfo() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        System.out.println("Let start game:");
        Move=0;
        initializeBoard();
        showInfo();

        for (int moveCount = 0; moveCount < 5; moveCount++) {
            System.out.println("Move:" + (Move + 1) + "\nPlayer:" + getName1() + " give your choise:");
            if (getName1() != null) {
                playerMove(getName1(), getSimbol1().charAt(0));
            }
            Move++;

            if (winnerCheck()) return;

            if(Move<9) {
                System.out.println("Move:" + (Move + 1) + "\nPlayer:" + getName2() + " give your choise:");
                if (getName2() != null) {
                    playerMove(getName2(), getSimbol2().charAt(0));
                }
                Move++;
                if (winnerCheck()) return;
            }
        }
    }

    public void playerMove(String playerName, char playerSimbol) {

        System.out.println("\nPlayer:" + playerName + " Make your move: ");
        int r=0;
        int i = -1, j = -1;
        while(r==0)
        {
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
            if (i >= 0 && i < 3 && j >= 0 && j < 3) {
                if (matrix[i][j] == '*') {
                    matrix[i][j] = playerSimbol;
                    r = 1;

                    System.out.println("\nCurrent board:");
                    showInfo();
                }else {
                    System.out.println("\nCell is already occupied! Choose another one.");
                }
            }else {
                System.out.println("\nCoordinates must be between 0 and 2!");
            }
        }
    }

    public boolean winnerCheck() {
        if (matrix[0][0] == 'x' && matrix[0][1] == 'x' && matrix[0][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[1][0] == 'x' && matrix[1][1] == 'x' && matrix[1][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[2][0] == 'x' && matrix[2][1] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][0] == 'x' && matrix[1][0] == 'x' && matrix[2][0] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][1] == 'x' && matrix[1][1] == 'x' && matrix[2][1] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'x' && matrix[1][2] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][0] == 'x' && matrix[1][1] == 'x' && matrix[2][2] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'x' && matrix[1][1] == 'x' && matrix[2][0] == 'x') {
            System.out.println("\nX is winner!!!");
            return true;
        }


        if (matrix[0][0] == 'o' && matrix[0][1] == 'o' && matrix[0][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[1][0] == 'o' && matrix[1][1] == 'o' && matrix[1][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[2][0] == 'o' && matrix[2][1] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][0] == 'o' && matrix[1][0] == 'o' && matrix[2][0] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][1] == 'o' && matrix[1][1] == 'o' && matrix[2][1] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'o' && matrix[1][2] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }

        if (matrix[0][0] == 'o' && matrix[1][1] == 'o' && matrix[2][2] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }
        if (matrix[0][2] == 'o' && matrix[1][1] == 'o' && matrix[2][0] == 'o') {
            System.out.println("\nO is winner!!!");
            return true;
        }

        System.out.println("\nNo winner yet...");
        return false;
    }
}




