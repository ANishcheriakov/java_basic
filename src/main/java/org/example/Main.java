package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть номер місяця (1-12), за яким шукати студентів: ");
        int month = sc.nextInt();

        List<Student> allStudents = dao.getAllStudents();

        List<Student> filtered = allStudents.stream()
                .filter(s -> s.getDateOfBirth().toLocalDate().getMonthValue() == month)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("Немає студентів, що народилися у цьому місяці.");
        } else {
            System.out.println("Список студентів, що народилися у цьому місяці:");
            for (Student s : filtered) {
                System.out.println(s);
            }
        }
    }
}
