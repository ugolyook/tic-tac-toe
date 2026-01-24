public class GameResultDto {

    public Player winner;
    public Player player1;
    public Player player2;
    public char[][] finalBoard;

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
}
