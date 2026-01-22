import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    public FileManager() {
    }

    public void dataSave(Dto dto) {
        System.out.println("\nStart saving game...");
        try (FileWriter writer = new FileWriter("game_data.txt", true)) {
            writer.write("\nGame data: ");
            writer.write("Gamer: " + dto.player1.getName() + "(" + dto.player1.getSimbol() + ")" + "\n");
            writer.write("Gamer: " + dto.player2.getName() + "(" + dto.player2.getSimbol() + ")" + "\n");

            writer.write("\nFinal board: ");
            char[][] board = dto.finalBoard;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    writer.write(board[i][j] + "");
                }
                writer.write("\n");
            }

            if(dto.winner.getName() != null){
                writer.write("\nWinner: " + dto.winner.getName() + "\n");
            }else{
                writer.write("\nDraw!!!");
            }

            System.out.println("\nGame is successfully saved!");

        } catch (IOException e) {
            System.out.println("\nError saving game!!!: " + e.getMessage());
        }
    }

    public void dataReader(){

    }//add it + make menu + cycle for 10 games

}
