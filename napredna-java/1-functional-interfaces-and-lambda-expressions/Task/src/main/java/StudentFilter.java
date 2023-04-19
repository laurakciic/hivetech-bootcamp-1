public class StudentFilter implements Filter {
    @Override
    public boolean hasLowGpa(Student student) {
        return student.getGpa() < 2;
    }
}
