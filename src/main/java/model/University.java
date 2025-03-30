package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties = new ArrayList<>();

    public University() {
    }

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Університет: ").append(name)
                .append(", Ректор: ").append(head.getFullName()) // Изменено на head
                .append(" (").append(head.getSex()).append("), Факультетів: ").append(faculties.size()).append("\n");

        for (Faculty faculty : faculties) {
            sb.append("  ").append(faculty.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return Objects.equals(name, that.name)
                && Objects.equals(head, that.head)
                && Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, faculties);
    }
}
