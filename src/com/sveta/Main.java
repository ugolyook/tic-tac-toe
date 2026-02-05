package com.sveta;

import com.sveta.core.ConsoleRunner;
import com.sveta.core.GameBoard;
import com.sveta.file.FileManager;

import java.util.Scanner;

class Main {
    private static GameBoard gameBoard;

    static void main(String[] args) {
        do {
            showMenuList();
            if (menuLoop()) return;
        } while (true);
    }

    private static boolean menuLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> printBoard(gameBoard);
            case 2 -> toPlay();
            case 3 -> toSaveData(gameBoard);
            case 4 -> FileManager.readData(); //
            case 5 -> toClose(scanner); //try with resources // methods in new class
        }
        return false;
    }

    private static void toSaveData(GameBoard gameBoard) {
        if (gameBoard != null) {
            FileManager fileManager = new FileManager();
            fileManager.saveData(gameBoard.toGameResult());
        } else {
            System.out.println("No game to save!");
        }
    }

    private static boolean toClose(Scanner scanner) {
        System.out.println("Program finished.");
        scanner.close();
        return true;
    }

    private static void toPlay() {
        ConsoleRunner consoleRunner = new ConsoleRunner();
        System.out.println("Let start game:");
        consoleRunner.play();
        gameBoard = consoleRunner.getBoard();
    }

    private static void showMenuList() {
        System.out.println("Hello players");
        System.out.println("Welcome to the tic-tac-toe!");
        System.out.println("1-Show table");
        System.out.println("2-Start game");
        System.out.println("3-Save data");
        System.out.println("4-Read data");
        System.out.println("5-End");
    }

    private static void printBoard(GameBoard gameBoard) {
        if (gameBoard != null) {
            System.out.println("\nCurrent game board:");
            System.out.println(gameBoard);
        } else {
            System.out.println("Board not initialized!");
        }
    }
}