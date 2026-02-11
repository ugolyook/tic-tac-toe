package com.sveta.file;

import com.sveta.model.Player;
import com.sveta.model.GameResultDto;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManagerJson {
    private static final String FILE_NAME = "game_data.json";
    private static final String FIRST_GAMER = "1 Gamer";
    private static final String SECOND_GAMER = "2 Gamer";
    private static final String FINAL_BOARD = "Final board";
    private static final String WINNER = "Winner";
    private static final String COLON = ":";
    private static final String NEXT_LINE_POINTER = "\n";

    public FileManagerJson() {
    }

    public void saveData(GameResultDto dto) {
        System.out.println(NEXT_LINE_POINTER + "Start saving game (JSON)...");

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            writer.write("{" + NEXT_LINE_POINTER);
            writer.write("  \"" + FIRST_GAMER + "\" \"" + dto.getPlayer1().getName() + "\"," + NEXT_LINE_POINTER);
            writer.write("  \"" + SECOND_GAMER + "\": \"" + dto.getPlayer2().getName() + "\"," + NEXT_LINE_POINTER);

            writer.write("  \"" + FINAL_BOARD + "\": [" + NEXT_LINE_POINTER);
            char[][] board = dto.getFinalBoard();

            for (int i = 0; i < board.length; i++) {
                writer.write("    [");
                for (int j = 0; j < board[i].length; j++) {
                    writer.write("\"" + board[i][j] + "\"");
                    if (j < board[i].length - 1) writer.write(", ");
                }
                writer.write("]");
                if (i < board.length - 1) writer.write(",");
                writer.write(NEXT_LINE_POINTER);
            }

            writer.write("  ]," + NEXT_LINE_POINTER);


            if (dto.getWinner() != null) {
                writer.write("  \"" + WINNER + "\": \"" + dto.getWinner().getName() + "\"" + NEXT_LINE_POINTER);
            } else {
                writer.write("  \"" + WINNER + "\": null" + NEXT_LINE_POINTER);
            }

            writer.write("}");

            System.out.println("Game is successfully saved in JSON!");

        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }


    public static GameResultDto readData() {
        System.out.println("Start reading JSON data...");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line.trim());
            }

            String content = json.toString();

            String p1Name = extractValue(content, FIRST_GAMER);
            String p2Name = extractValue(content, SECOND_GAMER);
            String winnerName = extractValue(content, WINNER);

            char[][] board = extractBoard(content);

            Player player1 = new Player(p1Name);
            Player player2 = new Player(p2Name);

            Player winner = null;
            if (winnerName != null) {
                winner = winnerName.equals(p1Name)
                        ? player1
                        : player2;
            }

            System.out.println("JSON data successfully read!");

            return new GameResultDto(player1, player2, board, winner);

        } catch (IOException e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
        return null;
    }

    private static String extractValue(String json, String key) {
        String pattern = "\"" + key + "\":";
        int start = json.indexOf(pattern);
        if (start == -1) return null;

        start += pattern.length();

        if (json.startsWith("null", start)) {
            return null;
        }

        int firstQuote = json.indexOf("\"", start);
        int secondQuote = json.indexOf("\"", firstQuote + 1);

        return json.substring(firstQuote + 1, secondQuote);
    }

    private static char[][] extractBoard(String json) {
        char[][] board = new char[3][3];

        int start = json.indexOf("\"" + FINAL_BOARD + "\"");
        start = json.indexOf("[", start);
        int end = json.indexOf("]", start);

        String boardContent = json.substring(start + 1, end);

        String[] rows = boardContent.split("\\],\\[");

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].replace("[", "").replace("]", "");
            String[] cells = row.replace("\"", "").split(",");

            for (int j = 0; j < cells.length; j++) {
                board[i][j] = cells[j].trim().charAt(0);
            }
        }

        return board;
    }
}




