package com.sveta;

import com.sveta.core.GameBoard;
import com.sveta.core.MainMethods;
import com.sveta.file.FileManager;
import com.sveta.file.FileManagerJson;

import java.util.Scanner;

class Main {
    private static GameBoard gameBoard;
    public static FileManagerJson fileManagerJson = new FileManagerJson();
    public static MainMethods mainMethods = new MainMethods();

    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
               mainMethods.showMenuList();
            } while (!menuLoop(scanner));
        }
    }

    private static boolean menuLoop( Scanner scanner) {
        System.out.print("Your choice: ");
        int option = scanner.nextInt();
        boolean result = false;
        scanner.nextLine();
        switch (option) {
            case 1 -> mainMethods.printBoard(gameBoard);
            case 2 -> gameBoard = mainMethods.toPlay();
            case 3 -> mainMethods.toSaveData(gameBoard);
            case 4 -> fileManagerJson.readData();
            case 5 -> result = mainMethods.toClose();
        }
        return result;
    }
}