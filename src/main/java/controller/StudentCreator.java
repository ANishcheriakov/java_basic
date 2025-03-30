package controller;

import model.*;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}
