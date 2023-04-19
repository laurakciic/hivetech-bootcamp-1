import java.util.List;
import java.util.stream.Collectors;

public class StudentUtils {

    static List<Student> filterStudents(List<Student> students, Filter filter) {
        students.removeIf(filter::hasLowGpa);
        return students;
    }

    static List<Student> mapStudents(List<Student> students, Mapper mapper) {
        return students.stream()
                .map(mapper::incrementAge)
                .collect(Collectors.toList());
    }
}
