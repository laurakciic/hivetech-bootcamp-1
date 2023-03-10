import java.io.*;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {

        double kilometers;
        double conversionFactor;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter kilometers: ");
            kilometers = scanner.nextDouble();

            System.out.print("Enter conversion factor: ");
            conversionFactor = scanner.nextDouble();

            if (kilometers <= 0 && conversionFactor <= 0) {
                System.out.println("Please make sure both kilometers and conversion factor are greater than zero.");
            } else if (kilometers <= 0) {
                System.out.println("Please make sure kilometers are greater than zero.");
            } else if (conversionFactor <= 0) {
                System.out.println("Please make sure conversion factor is greater than zero.");
            }
        } while (kilometers <= 0 || conversionFactor <= 0);

        File file = new File("conversion_factor.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("conversion factor = " + conversionFactor);
            writer.close();
            System.out.println("*** Successfully wrote to the file " + file.getName() + " ***");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        try {
            FileReader reader = new FileReader(file);
            char[] buffer = new char[100];
            reader.read(buffer);
            reader.close();

            String contents = new String(buffer);
            System.out.println("From file: " + contents.trim());
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate the file named " + file.getName() + ".");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error occurred while trying to read the file.");
            e.printStackTrace();
        }

        int miles = (int) (kilometers / conversionFactor);
        System.out.println("You entered " + kilometers + " km, which is approximately " + miles + " miles.");
    }
}
