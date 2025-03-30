package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Кафедра: ").append(name)
                .append(", ЗавКаф: ").append(head.getFullName())
                .append(" (").append(head.getSex()).append("), Груп: ").append(groups.size()).append("\n");

        for (Group group : groups) {
            sb.append("      ").append(group.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name)
                && Objects.equals(head, that.head)
                && Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }
}
