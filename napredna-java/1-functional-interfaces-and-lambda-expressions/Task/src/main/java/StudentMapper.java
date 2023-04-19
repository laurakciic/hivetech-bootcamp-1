public class StudentMapper implements Mapper {
    @Override
    public Student incrementAge(Student student) {
        int id = student.getId();
        String name = student.getName();
        int age = student.getAge() + 1;
        double gpa = student.getGpa();
        return new Student(id, name, age, gpa);
    }
}
