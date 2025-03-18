package org.example;

import java.util.Scanner;

public class Main {
    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM = -50;
    private static final int MAX_RANDOM = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту матриці (не більше 20): ");
        int rows = getValidInput(scanner);

        System.out.print("Введіть ширину матриці (не більше 20): ");
        int cols = getValidInput(scanner);

        System.out.print("Оберіть спосіб заповнення (1 - вручну, 2 - рандомно): ");
        int choice = scanner.nextInt();

        Matrix matrix = new Matrix(rows, cols);
        if (choice == 1) {
            matrix.fillManually(scanner);
        } else {
            matrix.fillRandomly(MIN_RANDOM, MAX_RANDOM);
        }

        matrix.display();
        System.out.println("Мінімальний елемент: " + MatrixUtils.findMin(matrix.getMatrix()));
        System.out.println("Максимальний елемент: " + MatrixUtils.findMax(matrix.getMatrix()));
        System.out.println("Середнє арифметичне: " + MatrixUtils.calculateAverage(matrix.getMatrix()));
    }

    private static int getValidInput( Scanner scanner) {
        int value;
        do {
            value = scanner.nextInt();
            if (value < 1 || value > MAX_SIZE) {
                System.out.print("Неправильне значення. Введіть число від 1 до 20: ");
            }
        } while (value < 1 || value > MAX_SIZE);
        return value;
    }
}