package com.sveta.core;

import com.sveta.file.FileManager;

public class MainMethods {

    MainMethods(){}

    public static void toSaveData(GameBoard gameBoard) {
        if (gameBoard != null) {
            FileManager fileManager = new FileManager();
            fileManager.saveData(gameBoard.toGameResult());
        } else {
            System.out.println("No game to save!");
        }
    }

    public static void toClose() {
        System.out.println("Program finished.");
    }

    public static GameBoard toPlay() {
        ConsoleRunner consoleRunner = new ConsoleRunner();
        System.out.println("Let start game:");
        consoleRunner.play();
        return consoleRunner.getBoard();
    }

    public static void showMenuList() {
        System.out.println("Hello players");
        System.out.println("Welcome to the tic-tac-toe!");
        System.out.println("1-Show table");
        System.out.println("2-Start game");
        System.out.println("3-Save data");
        System.out.println("4-Read data");
        System.out.println("5-End");
    }

    public static void printBoard(GameBoard gameBoard) {
        if (gameBoard != null) {
            System.out.println("\nCurrent game board:");
            System.out.println(gameBoard);
        } else {
            System.out.println("Board not initialized!");
        }
    }
}
