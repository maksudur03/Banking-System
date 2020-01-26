
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputController {

    public Account inputOfCreatingAccount(long id) {
        Account account = new Account();

        System.out.println("TYPE HOLDER NAME");
        account.setHolderName(getStringInput());

        System.out.println("TYPE NID NUMBER");
        account.setNID(getLongInput());

        System.out.println("TYPE INITIAL AMOUNT");
        account.setBalance(getDoubleInput());

        System.out.println("CHOOSE YOUR ACCOUNT TYPE");
        account.setAccountType(getStringInput());

        account.setId(id);
        System.out.println("ACCOUNT NUMBER\n" + account.getId());

        System.out.println();

        return account;
    }

    public int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        while (input == -1) {
            try {

                input = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Try again");

            }

            scanner.nextLine();

        }
        return input;
    }

    public long getLongInput() {
        Scanner scanner = new Scanner(System.in);
        long input = -1;
        while (input == -1) {
            try {
                input = scanner.nextLong();
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Try again");
            }
            scanner.nextLine();
        }
        return input;
    }

    public double getDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        double input = -1;
        while (input == -1) {
            try {
                input = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Try again");
            }
            scanner.nextLine();
        }
        return input;
    }

    private static String getStringInput() {
        return new Scanner(System.in).next();
    }
}
