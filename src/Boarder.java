public class Boarder {
    private final char[][] matrix;
    private final Player player1;
    private final Player player2;
    private Player winner;
    private boolean isDraw;

    public Boarder(Player player1, Player player2) {
        matrix = new char[3][3];
        initializeBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.winner = null;
        this.isDraw = false;
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
        initializeBoard();
        showInfo();
        int maxMoveNumbers = (matrix.length * matrix.length);

        for (int moveNumber = 0; moveNumber < maxMoveNumbers; moveNumber += 2) {
            Console console = new Console();
            Console.playConsole(player1.getName());
            playerMove(player1.getName(), player1.getSimbol(), console);

            if (isWinnerFound()) {
                return;
            }

            if (isDraw(moveNumber, maxMoveNumbers)) return;

            Console.playConsole(player2.getName());
            playerMove(player2.getName(), player2.getSimbol(),console);

            if (isDraw(moveNumber, maxMoveNumbers)) return;

        }
    }

    private boolean isDraw(int moveNumber, int maxMoveNumbers) {
        if (moveNumber + 1 == maxMoveNumbers) {
            Console.isDrawConsole();
            this.isDraw = true;
            return true;
        }
        return false;
    }

    public GameResultDto dto() {
        if (isDraw) {
            return new GameResultDto(player1, player2, matrix);
        } else {
            return new GameResultDto(player1, player2, matrix, winner);
        }

    }

    public void playerMove(String playerName, char playerSimbol, Console console) {

        int[] move = console.playerMoveConsole(playerName, matrix);
        int i = move[0];
        int j = move[1];
        matrix[i][j] = playerSimbol;

        System.out.println("\nCurrent board:");
        showInfo();
    }

    public boolean isWinnerFound() {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == player1.getSimbol() & matrix[i][1] == player1.getSimbol() & matrix[i][2] == player1.getSimbol()) {
                Console.isWinnerFoundConsole(player1.simbol);
                showInfo();
                this.winner = player1;
                return true;
            }
            if (matrix[i][0] == player2.getSimbol() & matrix[i][1] == player2.getSimbol() & matrix[i][2] == player2.getSimbol()) {
                Console.isWinnerFoundConsole(player2.simbol);
                showInfo();
                this.winner = player2;
                return true;
            }

            if (matrix[0][i] == player1.getSimbol() & matrix[1][i] == player1.getSimbol() & matrix[2][i] == player1.getSimbol()) {
                Console.isWinnerFoundConsole(player1.simbol);
                showInfo();
                this.winner = player1;
                return true;
            }
            if (matrix[0][i] == player2.getSimbol() & matrix[1][i] == player2.getSimbol() & matrix[2][i] == player2.getSimbol()) {
                Console.isWinnerFoundConsole(player2.simbol);
                showInfo();
                this.winner = player2;
                return true;
            }

        }
        if (matrix[0][0] == player1.getSimbol() & matrix[1][1] == player1.getSimbol() & matrix[2][2] == player1.getSimbol()) {
            Console.isWinnerFoundConsole(player1.simbol);
            showInfo();
            this.winner = player1;
            return true;
        }
        if (matrix[0][2] == player1.getSimbol() & matrix[1][1] == player1.getSimbol() & matrix[2][0] == player1.getSimbol()) {
            Console.isWinnerFoundConsole(player1.simbol);
            showInfo();
            this.winner = player1;
            return true;
        }

        if (matrix[0][0] == player2.getSimbol() & matrix[1][1] == player2.getSimbol() & matrix[2][2] == player2.getSimbol()) {
            Console.isWinnerFoundConsole(player2.simbol);
            showInfo();
            this.winner = player2;
            return true;
        }
        if (matrix[0][2] == player2.getSimbol() & matrix[1][1] == player2.getSimbol() & matrix[2][0] == player2.getSimbol()) {
            Console.isWinnerFoundConsole(player2.simbol);
            showInfo();
            this.winner = player2;
            return true;
        }

        return false;
    }

}




