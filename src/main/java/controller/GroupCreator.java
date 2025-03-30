package controller;

import model.*;

public class GroupCreator {
    public static Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}