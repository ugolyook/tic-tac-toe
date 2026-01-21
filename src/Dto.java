//метод меню, метод записи в файл с доской , чтение с файла с доской , запись 10 игр и удаление если будет больше, инфа в 1 месте
public class Dto {

    private final Player winner;
    private Player player1;
    private  Player player2;
    private  char[][] finalBoard;

    public Dto(Player player1, Player player2, char[][] finalBoard, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.finalBoard = finalBoard;
        this.winner = winner;

    }

    public Player getPlayer1() { return player1; }
    public void setPlayer1(Player player1) { this.player1 = player1; }

    public Player getPlayer2() { return player2; }
    public void setPlayer2(Player player2) { this.player2 = player2; }

}
