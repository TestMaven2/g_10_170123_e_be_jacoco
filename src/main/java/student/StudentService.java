package student;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Сервис, содержащий инструменты для работы со студентами {@link Student}
 *
 * @author Andrey Pomelov
 * @version 2.0.0
 */
public class StudentService {

    /**
     * Список студентов
     */
    private List<Student> students = new ArrayList<>();

    /**
     * Добавление студента в сервис
     *
     * @param student добавляемый студент
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Получение студента по идентификатору
     *
     * @param id    идентификатор, по которому требуется найти студента
     * @return      студент, соответствующий переданному идентификатору
     * @throws      NoSuchElementException в случае несуществующего в базе идентификатора
     */
    public Student getStudentById(int id) {
        List<Student> result = students.stream()
                .filter(x -> x.getId() == id)
                .limit(1)
                .toList();

        if (result.isEmpty()) {
            throw new NoSuchElementException("Не существующий идентификатор");
        }
        return result.get(0);
    }
}