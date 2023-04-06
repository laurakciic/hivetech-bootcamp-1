public class FilterImpl implements Filter {
    @Override
    public boolean filterStudent(Student student) {
        if (student.getGpa() > 2) return true;
        return false;
    }
}
