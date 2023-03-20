public class Student {
    String ime;
    String prezime;
    int godinaStudija;
    String brojIndeksa;

    public Student(String ime, String prezime, int godinaStudija, String brojIndeksa) {
        this.ime = ime;
        this.prezime = prezime;
        this.godinaStudija = godinaStudija;
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(int godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }
}
