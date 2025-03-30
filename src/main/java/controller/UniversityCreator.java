package controller;

import model.*;

public class UniversityCreator {
    public static University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}