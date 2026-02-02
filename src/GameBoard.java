class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message);
    }
}

public class GameBoard {
    private final char[][] matrix;
    private final Player player1;
    private final Player player2;
    private Player winner;
    private int moveCounter = 0;

    public GameBoard(Player player1, Player player2) {
        matrix = new char[3][3];
        initializeBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.winner = null;
    }

    private void initializeBoard() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = '*';
            }
        }
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                buffer.append(aChar).append(" ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public boolean isDraw() {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == '*') return false;
            }
        }
        return true;
    }

    public GameResultDto toGameResult() {
        if (isDraw()) {
            return new GameResultDto(player1, player2, matrix);
        }
        return new GameResultDto(player1, player2, matrix, winner);
    }

    public void move(Coordinates coordinates) throws InvalidMoveException {

        int i = coordinates.i;
        int j = coordinates.j;

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            throw new InvalidMoveException(
                    "Coordinates must be in range [0;" + (matrix.length - 1) + "]"
            );
        }

        if (matrix[i][j] != '*') {
            throw new InvalidMoveException(
                    "Cell [" + i + "," + j + "] is already occupied! Choose another one."
            );
        }

        Player currentPlayer = getCurrentPlayer();
        matrix[i][j] = currentPlayer.getSimbol();
        moveCounter++;

    }

    public Player getWinner() {
        return winner;
    }

    public Player getCurrentPlayer() {
        if (moveCounter % 2 == 0) return player1;
        else return player2;
    }

    public boolean isWinnerFound() {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == player1.getSimbol() & matrix[i][1] == player1.getSimbol() & matrix[i][2] == player1.getSimbol()) {
                this.winner = player1;
                return true;
            }
            if (matrix[i][0] == player2.getSimbol() & matrix[i][1] == player2.getSimbol() & matrix[i][2] == player2.getSimbol()) {
                this.winner = player2;
                return true;
            }

            if (matrix[0][i] == player1.getSimbol() & matrix[1][i] == player1.getSimbol() & matrix[2][i] == player1.getSimbol()) {
                this.winner = player1;
                return true;
            }
            if (matrix[0][i] == player2.getSimbol() & matrix[1][i] == player2.getSimbol() & matrix[2][i] == player2.getSimbol()) {
                this.winner = player2;
                return true;
            }

        }
        if (matrix[0][0] == player1.getSimbol() & matrix[1][1] == player1.getSimbol() & matrix[2][2] == player1.getSimbol()) {
            this.winner = player1;
            return true;
        }
        if (matrix[0][2] == player1.getSimbol() & matrix[1][1] == player1.getSimbol() & matrix[2][0] == player1.getSimbol()) {
            this.winner = player1;
            return true;
        }

        if (matrix[0][0] == player2.getSimbol() & matrix[1][1] == player2.getSimbol() & matrix[2][2] == player2.getSimbol()) {
            this.winner = player2;
            return true;
        }
        if (matrix[0][2] == player2.getSimbol() & matrix[1][1] == player2.getSimbol() & matrix[2][0] == player2.getSimbol()) {
            this.winner = player2;
            return true;
        }

        return false;
    }
}




