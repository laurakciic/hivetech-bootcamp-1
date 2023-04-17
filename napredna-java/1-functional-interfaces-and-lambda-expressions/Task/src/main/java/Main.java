import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Luka", 18, 1.3));
        students.add(new Student(2, "Laura", 19, 4.2));
        students.add(new Student(3, "Petar", 20, 4.3));
        students.add(new Student(4, "Ivan", 21, 4.4));

        Filter filter = new FilterImpl();
        Mapper mapper = new MapperImpl();

        StudentUtils.filterStudents(students, filter);
        StudentUtils.mapStudents(students, mapper);
    }
}
