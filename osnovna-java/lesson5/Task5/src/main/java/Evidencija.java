import java.util.ArrayList;
import java.util.List;

public class Evidencija {

    List<Student> studenti = new ArrayList<>();

    public void dodajStudenta(String ime, String prezime, int godinaStudija, String brojIndeksa) {
        Student student = new Student(ime, prezime, godinaStudija, brojIndeksa);
        studenti.add(student);
        System.out.println("Student dodan.");
        System.out.println();
    }

    public void pretragaPoIndeksu(String brojIndeksa) {
        for(Student student: studenti) {
            if(student.getBrojIndeksa().equals(brojIndeksa)) {
                System.out.println("Student pronađen: " + student.getIme() + " " + student.getPrezime());
            } else {
                System.out.println("Nije pronaden student s navedenim indeksom.");
            }
        }
        System.out.println();
    }

    public void ispisSvihStudenata() {
        System.out.println("---Popis studenata---");

        for(Student student: studenti) {
            System.out.println(student.getIme() + " " + student.getPrezime());
        }
        System.out.println();
    }
}
