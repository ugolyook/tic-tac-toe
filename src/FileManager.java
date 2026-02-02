import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public FileManager() {
    }

    public static void saveData(GameResultDto dto) {
        System.out.println("\nStart saving game...");
        try (FileWriter writer = new FileWriter("game_data.txt", true)) {
            writer.write("\nGame data: \n");
            writer.write("1 Gamer: " + dto.getPlayer1().getName() + "\n");
            writer.write("2 Gamer: " + dto.getPlayer2().getName() + "\n");

            writer.write("Final board: \n");
            char[][] board = dto.getFinalBoard();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    writer.write(board[i][j] + " ");
                }
                writer.write("\n");
            }

            if (dto.getWinner() != null) {
                writer.write("\nWinner: " + dto.getWinner().getName() + "\n");
            } else {
                writer.write("\nDraw!!!");
            }

            System.out.println("\nGame is successfully saved!");

        } catch (IOException e) {
            System.out.println("\nError saving game!!!: " + e.getMessage());
        }
    }

    public static GameResultDto readData() {
        System.out.println("\nStart reading data...");
        try (BufferedReader reader = new BufferedReader(new FileReader("game_data.txt"))) {

            String p1Name = null, p2Name = null;
            char[][] board = new char[3][3];
            Player winner = null;
            String line;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("1 Gamer: ")) {
                    String[] parts = line.split(":", 2);
                    if (parts.length > 1) {
                        p1Name = parts[1].trim();
                    }
                }

                if (line.startsWith("2 Gamer: ")) {
                    String[] parts = line.split(":", 2);
                    if (parts.length > 1) {
                        p2Name = parts[1].trim();
                    }
                }

                if (line.startsWith("Final board: ")) {
                    for (int i = 0; i < 3; i++) {
                        String[] cells = reader.readLine().split(" ");
                        for (int j = 0; j < 3; j++) {
                            board[i][j] = cells[j].charAt(0);
                        }
                    }
                }

                if (line.startsWith("Winner:")) {
                    String[] parts = line.split(":", 2);
                    if (parts.length > 1) {
                        String winnerName = parts[1].trim();
                        if (winnerName.equals(p1Name)) {
                            winner = new Player(p1Name);
                        } else if (winnerName.equals(p2Name)) {
                            winner = new Player(p2Name);
                        }
                    }
                }
            }

            Player player1 = new Player(p1Name);
            Player player2 = new Player(p2Name);

            System.out.println("\nData is successfully saved!");
            return new GameResultDto(player1, player2, board, winner);
        } catch (IOException e) {
            System.out.println("Error with reading: " + e.getMessage());
        }
        return null;
    }
}
