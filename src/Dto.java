//метод меню, метод записи в файл с доской , чтение с файла с доской , запись 10 игр и удаление если будет больше, инфа в 1 месте
public class Dto {

    public final Player winner;
    public Player player1;
    public   Player player2;
    public   char[][] finalBoard;

    public Dto(Player player1, Player player2, char[][] finalBoard, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.finalBoard = finalBoard;
        this.winner = winner;

    }

}
