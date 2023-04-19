import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Luka", 18, 4.3));
        students.add(new Student(2, "Laura", 19, 4.2));
        students.add(new Student(3, "Ivan", 20, 4.1));
        students.add(new Student(4, "Marko", 21, 1.4));

        Filter filter = new StudentFilter();
        Mapper mapper = new StudentMapper();

        StudentUtils.filterStudents(students, filter);
        List<Student> olderStudents = StudentUtils.mapStudents(students, mapper);

        System.out.println("Students that passed the year and had birthdays: ");
        olderStudents.forEach(student -> System.out.println(student.getName() + ", " + student.getAge()));
    }
}
