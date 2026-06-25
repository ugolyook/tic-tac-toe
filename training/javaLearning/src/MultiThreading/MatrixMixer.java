package MultiThreading;

import java.util.*;

public class MatrixMixer {
    private int[][] sumParallel(int[][] matrixA, int[][] matrixB) throws InterruptedException {
        if (matrixA.length != matrixB.length
                && matrixA[0].length != matrixB[0].length) {
            throw new RuntimeException("Matrix have different sizes");
        }

        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] matrixC = new int[rows][cols];

        int cores = Runtime.getRuntime().availableProcessors();
        int threadsCount = Math.min(cores, rows);

        int rowsPerThread = rows / threadsCount;
        List<Thread> threads = new ArrayList<>();

        for (int t = 0; t < rows; t++) {
            int startRow = t * rowsPerThread;
            int endRow = (t == threadsCount - 1) ? rows : (t + 1) * rowsPerThread;

            Thread virtualThread = Thread.startVirtualThread(() -> {
//            Thread thread = new Thread(() -> {
                System.out.println("New thread was started!");
                for (int i = startRow; i < endRow; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrixC[i][j] = matrixA[i][j] + matrixB[i][j];////////////////// effectively final
                    }
                }
            });
            threads.add(virtualThread);
//            thread.start();

        }

        for (var thread : threads) {
            thread.join();
        }

        return matrixC;
    }

    private int[][] sum(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length
                && matrixA[0].length != matrixB[0].length) {
            throw new RuntimeException("Matrix have different sizes");
        }

        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] matrixC = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return matrixC;
    }

    static void main(String[] args) throws InterruptedException {
        Result result = getMatrix();
        MatrixMixer matrixMixer = new MatrixMixer();

        System.out.println("Sum of matrix without tread time: ");
        toString(matrixMixer.sum(result.matrixA(), result.matrixB()));
        System.out.println("Sum of matrix with tread time: ");
        toString(matrixMixer.sumParallel(result.matrixA(), result.matrixB()));
    }

    private static Result getMatrix() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Now you can enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Now you can enter number of cols: ");
        int cols = scanner.nextInt();

        int[][] matrixA = getInts(rows, cols, random);
        int[][] matrixB = getInts(rows, cols, random);

        return new Result(matrixA, matrixB);
    }

    private record Result(int[][] matrixA, int[][] matrixB) {
    }

    private static int[][] getInts(int rows, int cols, Random random) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    private static void toString(int[][] result) {
        long timeBefore = System.nanoTime();
        long timeAfter = System.nanoTime();

//        System.out.println(Arrays.deepToString(result));
        System.out.println((timeAfter - timeBefore));
    }
}
