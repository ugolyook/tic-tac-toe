package com.sveta;

import com.sveta.core.GameBoard;
import com.sveta.core.MainMethods;
import com.sveta.file.FileManager;

import java.util.Scanner;

class Main {
    private static GameBoard gameBoard;

    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                MainMethods.showMenuList();
            } while (!menuLoop(scanner));
        }
    }

    private static boolean menuLoop( Scanner scanner) {
        System.out.print("Your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> MainMethods.printBoard(gameBoard);
            case 2 -> gameBoard = MainMethods.toPlay();
            case 3 -> MainMethods.toSaveData(gameBoard);
            case 4 -> FileManager.readData();
            case 5 -> MainMethods.toClose();
        }
        return false;
    }
}