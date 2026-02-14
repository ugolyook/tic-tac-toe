package com.sveta.core;

import com.sveta.exception.InvalidMoveException;
import com.sveta.model.Coordinates;
import com.sveta.model.Player;

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ConsoleRunner {
    private final Scanner scanner;
    GameBoard board;

    public ConsoleRunner() {
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        Player gamer1 = initializePlayers(scanner);
        Player gamer2 = initializePlayers(scanner);
        board = new GameBoard(gamer1, gamer2);

        while (!board.isWinnerFound() && !board.isDraw()) {
            System.out.println("\nCurrent game board:");
            System.out.println(board.toString());
            toMoveCoordinates();
        }
        if (board.isWinnerFound()) {
            System.out.println("\n" + board.getWinner().getName() + " is winner\n");
        } else System.out.println("\nIt is draw!\n");
    }

    private void toMoveCoordinates() {
        var coordinates = getPlayerMoveCoordinates();
        try {
            board.move(coordinates);
        } catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
        }
    }

    public Coordinates getPlayerMoveCoordinates() {
        int i = -1;
        int j = -1;
        System.out.println("\ncom.sveta.model.Player:" + board.getCurrentPlayer() + " Make your move: ");
        System.out.print("\nEnter your i (0-2): ");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.print("\nEnter your j (0-2): ");
        if (scanner.hasNextInt()) {
            j = scanner.nextInt();
            scanner.nextLine();
        }
        return new Coordinates(i, j);
    }

    public Player initializePlayers(Scanner scanner) {
        Player gamer = new Player();

        System.out.print("Enter gamer name: ");
        gamer.setName(scanner.nextLine().toLowerCase());

        System.out.print("Enter gamer simbol(x/o): ");
        String input = scanner.nextLine().trim();

        char simbol = symbolValidator(input, scanner);
        gamer.setSimbol(simbol);

        System.out.println("Initial data");
        String data = gamer.toString();
        System.out.println("Players:" + data);
        return gamer;
    }

    private char symbolValidator(String input, Scanner scanner) {
        if ((input.length() != 1) || (input.charAt(0) != 'x' && input.charAt(0) != 'o')) {
            System.out.println("\nTry again...");
            System.out.print("\nEnter gamer simbol (x/o): ");
            input = scanner.nextLine().trim();

            return symbolValidator(input, scanner);
        } else {
            return input.charAt(0);
        }
    }

    public GameBoard getBoard() {
        return board;
    }
}
