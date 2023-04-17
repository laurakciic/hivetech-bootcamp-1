import java.util.ArrayList;
import java.util.List;

public class Evidencija {

    List<Student> studenti = new ArrayList<>();

    public void dodajStudenta(String ime, String prezime, int godinaStudija, String brojIndeksa, Profesor profesor) {
        Student student = new Student();
        student.setIme(ime);
        student.setPrezime(prezime);
        student.setGodinaStudija(godinaStudija);
        student.setBrojIndeksa(brojIndeksa);
        student.setProfesor(profesor);

        studenti.add(student);
        System.out.println("Student dodan.");
        System.out.println();
    }

    public void pretragaPoIndeksu(String brojIndeksa) {
        for(Student student: studenti) {
            if(student.getBrojIndeksa().equals(brojIndeksa)) {
                System.out.println("Student pronađen: " + student.getIme() + " " + student.getPrezime());
            }
        }
        System.out.println();
    }

    public void ispisSvihStudenata() {
        System.out.println("---Popis studenata---");

        for(Student student: studenti) {
            System.out.println(student.getIme() + " " + student.getPrezime() + ", profesor: " + student.getProfesor().getIme() + "  " + student.getProfesor().getPrezime());
        }
        System.out.println();
    }

    public Profesor kreirajProfesora(String ime, String prezime) {
        Profesor profesor = new Profesor();
        profesor.setIme(ime);
        profesor.setPrezime(prezime);

        return profesor;
    }
}
