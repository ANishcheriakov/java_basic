package org.example;

import java.sql.Date;

public class Student {
    private int id;
    private String last_name;
    private String first_name;
    private String middle_name;
    private Date birth_date;       // Дата народження
    private int record_book_number;   // Залікова книжка

    public Student(int id, String last_name, String first_name, String middle_name, Date birth_date, int record_book_number) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.birth_date = birth_date;
        this.record_book_number = record_book_number;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return last_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public Date getDateOfBirth() {
        return birth_date;
    }

    public int getRecordBookNumber() {
        return record_book_number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id =" + id +
                ", last name = '" + last_name + '\'' +
                ", first name = '" + first_name + '\'' +
                ", middle name = '" + middle_name + '\'' +
                ", birth date = " + birth_date +
                ", record book number = '" + record_book_number + '\'' +
                '}';
    }
}

