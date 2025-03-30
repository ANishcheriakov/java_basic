package main;

import controller.*;
import model.*;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    private static void createTypicalUniversity() {

        Human rector = new Human("Дмитро", "Мельник", "Сергійович", Sex.MALE) {};


        University university = UniversityCreator.createUniversity("Національний Університет", rector);
        System.out.println(university);


        Human decan = new Human("Андрій", "Іванов", "Дмитрович", Sex.MALE) {};
        Faculty faculty = FacultyCreator.createFaculty("Факультет комп'ютерних наук", decan);
        System.out.println(faculty);


        Human departmentHead = new Human("Софія", "Коваленко", "Васильївна", Sex.FEMALE) {};
        Department department = DepartmentCreator.createDepartment("Кафедра програмування", departmentHead);
        System.out.println(department);


        Human groupHead = new Human("Олександр", "Понаморенко", "Григорович", Sex.MALE) {};
        Group group = GroupCreator.createGroup("Група 1", groupHead);
        System.out.println(group);


        Student student1 = StudentCreator.createStudent("Кирило", "Пушкарьов", "Володимирович", Sex.MALE);
        Student student2 = StudentCreator.createStudent("Альбіна", "Шевченко", "Ігорівна", Sex.FEMALE);
        System.out.println(student1);
        System.out.println(student2);
    }
}
