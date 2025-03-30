package main;

import controller.*;
import model.*;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
        System.out.println(university);

        String filename = "university.json";
        JsonManager.writeToFile(university, filename);

        University restored = JsonManager.readFromFile(filename);
        System.out.println("Відновленний з JSON:");
        System.out.println(restored);

        System.out.println("Равні ці об'єкти? " + university.equals(restored));
    }

    /**
     * Пример создания университета с 1 факультетом, 1 кафедрой, 1 группой и 2 студентами
     */
    public static University createTypicalUniversity() {
        Person rector = new Person("Іван", "Петров", "Сергійович", Sex.MALE);
        University university = UniversityCreator.createUniversity("Національний Університет", rector);

        Person dean = new Person("Петро", "Іванов", "Валерійович", Sex.MALE);
        Faculty faculty = FacultyCreator.createFaculty("Факультет Інформатики", dean);

        Person depHead = new Person("Марія", "Коваленко", "Вікторівна", Sex.FEMALE);
        Department department = DepartmentCreator.createDepartment("Кафедра Програмування", depHead);

        Person groupHead = new Person("Олег", "Сидоренко", "Володимирович", Sex.MALE);
        Group group = GroupCreator.createGroup("ІП-01", groupHead);

        Student st1 = StudentCreator.createStudent("Андрій", "Шевченко", "Миколайович", Sex.MALE);
        Student st2 = StudentCreator.createStudent("Олена", "Кравчук", "Миколаївна", Sex.FEMALE);

        group.addStudent(st1);
        group.addStudent(st2);

        department.addGroup(group);

        faculty.addDepartment(department);

        university.addFaculty(faculty);

        return university;
    }
}

