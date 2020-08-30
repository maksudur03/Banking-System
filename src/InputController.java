
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputController {

    public Account inputOfCreatingAccount(long id) {
        String holderName;
        long nid;
        double balance;
        Account.AccountType accountType;
        Account account = new Account();

        System.out.println("TYPE HOLDER NAME");
        holderName = getStringInput();
        account.setHolderName(holderName);

        System.out.println("TYPE NID NUMBER");
        nid = getLongInput();
        account.setNID(nid);

        System.out.println("TYPE INITIAL AMOUNT");
        balance = getDoubleInput();
        account.setBalance(balance);

        System.out.println("CHOOSE YOUR ACCOUNT TYPE");
        accountType=selectAccountType();
        account.setAccountType(accountType);


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
            /*
            String garbage=scanner.nextLine();
            System.out.println(garbage);
             */
        }
        return input;
    }
    //keyboard.nextLine(); is not here to consume \n but to consume invalid token (along with rest of line but that is not necessary)
// which is not consumed when exception is thrown. So without nextLine() or next() in catch section which doesn't have problem
// with consuming this token loop will try to parse same data infinitely.
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

    public void showAccountTypes() {
        for (Account.AccountType accountType : Account.AccountType.values()) {
            System.out.println(accountType.ordinal() + 1 + ". " + accountType);
        }
        System.out.println("Press the adjacent button to select account type");
    }

    public Account.AccountType selectAccountType() {
        showAccountTypes();
        int index=getIntInput();
        while (true) {
            switch (index) {
                case 1:
                    return Account.AccountType.SAVINGS;
                case 2:
                    return Account.AccountType.SALARY;
                case 3:
                    return Account.AccountType.STUDENT;
                case 4:
                    return Account.AccountType.INSURANCE;
                default:
                    System.out.println("Wrong Value.Try again.");
                    index = getIntInput();
            }
        }

    }
}
