public class GameResultDto {

    private Player winner;
    private Player player1;
    private Player player2;
    private char[][] finalBoard;

    public GameResultDto(Player player1, Player player2, char[][] finalBoard, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.finalBoard = finalBoard;
        this.winner = winner;
    }

    public GameResultDto(Player player1, Player player2, char[][] finalBoard) {
        this.player1 = player1;
        this.player2 = player2;
        this.finalBoard = finalBoard;
    }

    public GameResultDto() {

    }

    public Player getWinner() {
        return winner;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public char[][] getFinalBoard() {
        return finalBoard;
    }
}

