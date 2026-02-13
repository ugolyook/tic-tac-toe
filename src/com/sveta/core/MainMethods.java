package com.sveta.core;

import com.sveta.file.FileManager;
import com.sveta.file.impl.FileManagerJson;

public class MainMethods {

    public MainMethods() {
    }

    public void toSaveData(GameBoard gameBoard) {
        if (gameBoard != null) {
            FileManager manager = new FileManagerJson();
            manager.saveData(gameBoard.toGameResult());
        } else {
            System.out.println("No game to save!");
        }
    }

    public boolean toClose() {
        System.out.println("Program finished.");
        return true;
    }

    public GameBoard toPlay() {
        ConsoleRunner consoleRunner = new ConsoleRunner();
        System.out.println("Let start game:");
        consoleRunner.play();
        return consoleRunner.getBoard();
    }

    public void showMenuList() {
        System.out.println("Hello players");
        System.out.println("Welcome to the tic-tac-toe!");
        System.out.println("1-Show table");
        System.out.println("2-Start game");
        System.out.println("3-Save data");
        System.out.println("4-Read data");
        System.out.println("5-End");
    }

    public void printBoard(GameBoard gameBoard) {
        if (gameBoard != null) {
            System.out.println("\nCurrent game board:");
            System.out.println(gameBoard);
        } else {
            System.out.println("Board not initialized!");
        }
    }
}
