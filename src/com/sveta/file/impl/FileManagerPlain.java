package com.sveta.file.impl;

import com.sveta.file.FileManager;
import com.sveta.model.Player;
import com.sveta.model.GameResultDto;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManagerPlain implements FileManager {
    private static final String FILE_NAME = "game_data.txt";
    private static final String FIRST_GAMER = "1 Gamer";
    private static final String SECOND_GAMER = "2 Gamer";
    private static final String FINAL_BOARD = "Final board";
    private static final String WINNER = "Winner";
    private static final String COLON = ":";
    private static final String RECORD_TEMPLATE = """
            Game data: 
            %s: %s
            %s: %s
            %s:
            %s
            
            %s: %s
            """;
    private static final String NEXT_LINE_POINTER = "\n";

    public void saveData(GameResultDto dto) {
        System.out.println(NEXT_LINE_POINTER + "Start saving game...");
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(NEXT_LINE_POINTER + "Game data: " + NEXT_LINE_POINTER); //

            String resaultText = RECORD_TEMPLATE.formatted(
                    FIRST_GAMER, dto.getPlayer1().getName(),
                    SECOND_GAMER, dto.getPlayer2().getName(),
                    FINAL_BOARD, dto.getBoardString(),
                    WINNER, dto.getGameResult()
            );

            writer.write(resaultText);

            System.out.println("Game is successfully saved!");

        } catch (IOException e) {
            System.out.println("Error saving game!!!: " + e.getMessage());
        }
    }

    public List<GameResultDto> readData() {
        System.out.println("Start reading data...");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String p1Name = null, p2Name = null;
            char[][] board = new char[3][3];
            Player winner = null;
            String line;

            while ((line = reader.readLine()) != null) {

                p1Name = ifGamer(line, p1Name, FIRST_GAMER);
                p2Name = ifGamer(line, p2Name, SECOND_GAMER);

                if (line.startsWith(FINAL_BOARD)) {
                    int rowIndex = 0;
                    while (rowIndex < 3) {
                        String row = reader.readLine();
                        if (row == null) break;
                        row = row.trim();
                        if (!row.matches("[xo\\*] [xo\\*] [xo\\*]")) {
                            continue;
                        }
                        String[] cells = row.split(" ");
                        for (int j = 0; j < 3; j++) {
                            board[rowIndex][j] = cells[j].charAt(0);
                        }
                        rowIndex++;
                    }
                }


                if (line.startsWith(WINNER)) {
                    String[] parts = line.split(COLON, 2);
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

            System.out.println("Data is successfully read!");

            ArrayList<GameResultDto> list = new ArrayList<>();
            list.add(new GameResultDto(player1, player2, board, winner));
            return list;
        } catch (IOException e) {
            System.out.println("Error with reading: " + e.getMessage());
        }
        return null;
    }

    private static String ifGamer(String line, String name, String gamerTag) {
        if (line.startsWith(gamerTag)) {
            String[] parts = line.split(COLON, 2);
            if (parts.length > 1) {
                name = parts[1].trim();
            }
        }
        return name;
    }
}
