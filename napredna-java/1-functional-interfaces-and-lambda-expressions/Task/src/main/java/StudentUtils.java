import java.util.ArrayList;
import java.util.List;

public class StudentUtils {

    static List<Student> filterStudents(List<Student> students, Filter filter) {
        for (Student student: students) {
            if (!filter.filterStudent(student)) {       // returns false if student has low GPA
                students.remove(student);               // remove students with low GPA
            }
        }
        return students;
    }

    static List<Student> mapStudents(List<Student> students, Mapper mapper) {
        List<Student> mappedStudents = new ArrayList<>();

        for (Student student: students) {
            mappedStudents.add(mapper.mapStudent(student));
        }
        return mappedStudents;
    }
}
