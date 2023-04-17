import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String ime, prezime, brojIndeksa, indeksZaPretragu;
        String imeProfesora, prezimeProfesora;
        int godinaStudija;
        int menu = 0;
        boolean shouldContinue = true;

        Profesor profesor;

        Evidencija evidencija = new Evidencija();

        do {
            System.out.println("Odaberite opciju: ");
            System.out.println("1. Dodaj studenta");
            System.out.println("2. Pretraga po indeksu");
            System.out.println("3. Ispis svih studenata");
            System.out.println("4. Izlaz");

            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Unesite ime: ");
                    ime = scanner.next();

                    System.out.print("Unesite prezime: ");
                    prezime = scanner.next();

                    System.out.print("Unesite godinu studija: ");
                    godinaStudija = scanner.nextInt();

                    System.out.print("Unesite broj indeksa: ");
                    brojIndeksa = scanner.next();

                    System.out.print("Unesite ime profesora kojeg zelite dodijeliti studentu: ");
                    imeProfesora = scanner.next();

                    System.out.print("Unesite prezime profesora kojeg zelite dodijeliti studentu: ");
                    prezimeProfesora = scanner.next();

                    profesor = evidencija.kreirajProfesora(imeProfesora, prezimeProfesora);
                    evidencija.dodajStudenta(ime, prezime, godinaStudija, brojIndeksa, profesor);
                    break;
                case 2:
                    System.out.print("Unesite indeks za pretragu: ");
                    indeksZaPretragu = scanner.next();

                    evidencija.pretragaPoIndeksu(indeksZaPretragu);
                    break;
                case 3:
                    evidencija.ispisSvihStudenata();
                    break;
                case 4:
                    shouldContinue = false;
                    System.out.println("Doviđenja!");
                    break;
                default:
                    break;
            }
        } while(shouldContinue);

        scanner.close();
    }
}
