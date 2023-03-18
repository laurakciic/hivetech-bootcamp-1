import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = 0;
        int sum = 0;

        do {
            try {
                System.out.print("Enter an integer: ");
                input = scanner.nextInt();

                switch (input % 7) {
                    case 0 -> System.out.println("Sunday");
                    case 1 -> System.out.println("Monday");
                    case 2 -> System.out.println("Tuesday");
                    case 3 -> System.out.println("Wednesday");
                    case 4 -> System.out.println("Thursday");
                    case 5 -> System.out.println("Friday");
                    case 6 -> System.out.println("Saturday");
                }

                if (input == 0) {
                    continue;
                } else if (input % 2 == 0 && input > 0) {
                    sum += input;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter an integer.");
                scanner.nextLine();
            }
        } while (input >= 0);

        scanner.close();
        System.out.println("Sum: " + sum);
    }
}
