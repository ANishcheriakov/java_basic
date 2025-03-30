package model;

public class Group {
    private String name;
    private Human head;

    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    @Override
    public String toString() {
        return "Група: " + name + ", Староста: " + head;
    }
}