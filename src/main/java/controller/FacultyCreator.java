package controller;

import model.*;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}