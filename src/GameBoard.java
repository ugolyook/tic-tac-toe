public class GameBoard {
    private final char[][] matrix;
    private final Player player1;
    private final Player player2;
    private Player winner;
    private boolean isDraw;

    public GameBoard(Player player1, Player player2) {
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

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                buffer.append(matrix[i][j]).append(" ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    private boolean isDraw() {//refresh
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '*') return false;
            }
        }
        return true;
    }

    public GameResultDto toGameResault() {
        if (isDraw) {
            return new GameResultDto(player1, player2, matrix);
        } else {
            return new GameResultDto(player1, player2, matrix, winner);
        }

    }

    public String move(Player playerName, int i, int j) {
        StringBuffer buffer = new StringBuffer();
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix.length) {
            if (matrix[i][j] == '*') {
                matrix[i][j] = playerName.simbol;
            } else {
                buffer.append("Cell is already occupied! Choose another one.");
            }
        } else {
            buffer.append("Coordinates must be between 0 and 2!");
        }
        toString();
        return buffer.toString();
    }

//    public Player getWinner(boolean isDraw, Player winner) {
//
//    }

    public boolean isWinnerFound() {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == player1.getSimbol() & matrix[i][1] == player1.getSimbol() & matrix[i][2] == player1.getSimbol()) {
                toString();
                this.winner = player1;
                return true;
            }
            if (matrix[i][0] == player2.getSimbol() & matrix[i][1] == player2.getSimbol() & matrix[i][2] == player2.getSimbol()) {
                toString();
                this.winner = player2;
                return true;
            }

            if (matrix[0][i] == player1.getSimbol() & matrix[1][i] == player1.getSimbol() & matrix[2][i] == player1.getSimbol()) {
                toString();
                this.winner = player1;
                return true;
            }
            if (matrix[0][i] == player2.getSimbol() & matrix[1][i] == player2.getSimbol() & matrix[2][i] == player2.getSimbol()) {
                toString();
                this.winner = player2;
                return true;
            }

        }
        if (matrix[0][0] == player1.getSimbol() & matrix[1][1] == player1.getSimbol() & matrix[2][2] == player1.getSimbol()) {
            toString();
            this.winner = player1;
            return true;
        }
        if (matrix[0][2] == player1.getSimbol() & matrix[1][1] == player1.getSimbol() & matrix[2][0] == player1.getSimbol()) {
            toString();
            this.winner = player1;
            return true;
        }

        if (matrix[0][0] == player2.getSimbol() & matrix[1][1] == player2.getSimbol() & matrix[2][2] == player2.getSimbol()) {
            toString();
            this.winner = player2;
            return true;
        }
        if (matrix[0][2] == player2.getSimbol() & matrix[1][1] == player2.getSimbol() & matrix[2][0] == player2.getSimbol()) {
            toString();
            this.winner = player2;
            return true;
        }

        return false;
    }

}




