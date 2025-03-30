package model;

public class University {
    private String name;
    private Human head;

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    @Override
    public String toString() {
        return "Університет: " + name + ", Ректор: " + head;
    }
}
