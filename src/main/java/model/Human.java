package model;

import java.util.Objects;

public  class Human {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Sex sex;

    // Для JSON (библиотеки десериализации), нужен пустой конструктор.
    public Human() {
    }

    public Human(String firstName, String lastName, String middleName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Sex getSex() {
        return sex;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " (" + sex + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        // Можно так: if (getClass() != obj.getClass()) return false;
        // Либо так, если хотим сравнивать все подтипы Human:
        if (!(obj instanceof Human)) return false;

        Human that = (Human) obj;
        return Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.middleName, that.middleName)
                && this.sex == that.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, sex);
    }
}