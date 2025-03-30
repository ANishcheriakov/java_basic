import controller.JsonManager;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;

public class UniversityTest {

    @Test
    public void testUniversityJsonSerialization() {
        // 1. Создаём oldUniversity с нужной иерархией:
        University oldUniversity = createBigUniversity();

        // 2. Записываем в файл:
        String filename = "test_university.json";
        JsonManager.writeToFile(oldUniversity, filename);

        // 3. Считываем из файла обратно:
        University newUniversity = JsonManager.readFromFile(filename);

        // 4. Сравниваем:
        Assertions.assertTrue(
                oldUniversity.equals(newUniversity),
                "Сериализованный и десериализованный университет должны быть равны!"
        );

        // Удалим временный файл
        new File(filename).delete();
    }

    /**
     * Создаём университет, в котором:
     *   2 факультета,
     *     в каждом факультете 2 кафедры,
     *       в каждой кафедре 2 группы,
     *         в каждой группе по 2 студента.
     */
    private University createBigUniversity() {
        Person rector = new Person("Володимир", "Ректоренко", "Іванович", Sex.MALE);
        University university = new University("Великий Університет", rector);

        // 2 факультета:
        for (int f = 1; f <= 2; f++) {
            Person dean = new Person("Декан" + f, "Деканов", "Деканович", Sex.MALE);
            Faculty faculty = new Faculty("Факультет" + f, dean);

            // В каждом факультете 2 кафедры
            for (int d = 1; d <= 2; d++) {
                Person depHead = new Person("ЗавКаф" + d, "ЗавКафедров", "Петрович", Sex.MALE);
                Department department = new Department("Кафедра" + d, depHead);

                // В каждой кафедре 2 группы
                for (int g = 1; g <= 2; g++) {
                    Person groupHead = new Person("Староста" + g, "Старостенко", "Васильович", Sex.MALE);
                    Group group = new Group("Група" + g, groupHead);

                    // В каждой группе 2 студента
                    for (int s = 1; s <= 2; s++) {
                        Student st = new Student(
                                "Студент" + s,
                                "Студентов" + g + d + f,
                                "Отче" + s,
                                (s % 2 == 0 ? Sex.FEMALE : Sex.MALE)
                        );
                        group.addStudent(st);
                    }

                    department.addGroup(group);
                }

                faculty.addDepartment(department);
            }

            university.addFaculty(faculty);
        }

        return university;
    }
}
