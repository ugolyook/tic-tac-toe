package com.sveta.model;

import com.sveta.core.GameBoard;

public class GameResultDto {

    private Player winner;
    private final Player player1;
    private final Player player2;
    private final char[][] finalBoard;

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

    public char[][] getFinalBoard() {
        return finalBoard;
    }

    public Player getWinner() {
        return winner;
    }

    public String getGameResult() {
        if (getWinner() != null) {
            return winner.getName();
        } else {
            return "Draw";
        }
    }

    public String getBoardString() {
        if (finalBoard == null) {
            return "Board is empty";
        }

        StringBuilder sb = new StringBuilder();

        for (char[] chars : finalBoard) {
            for (char aChar : chars) {
                sb.append(aChar).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}

