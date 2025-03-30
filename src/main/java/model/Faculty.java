package model;

public class Faculty {
    private String name;
    private Human head;

    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    @Override
    public String toString() {
        return "Факультет: " + name + ", Декан: " + head;
    }
}