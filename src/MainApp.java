import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
    private Bank bank;
    private InputController inputController;
    public boolean state = true;

    public MainApp() {
        this.bank = Bank.getBank();
        this.inputController = new InputController();

    }
    
    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.execute();
    }


    private void execute() {
        //Account a1 = new Account("munif", 12345, 123, 300, "S");
        Account a2 = new Account("dipto", 24678, 123, 500, Account.AccountType.INSURANCE);
        bank.addAccount(new Account("munif", 12345, 123, 300, Account.AccountType.SALARY));
        bank.addAccount(a2);
        showMenu();
        menuHandling(inputController.getIntInput());
    }

    private void showMenu() {
        StringBuilder screen = new StringBuilder("Welcome to Bank")
                .append("\n")
                .append("1.CREATE ACCOUNT")
                .append("\n")
                .append("2.SEE ACCOUNT DETAILS")
                .append("\n")
                .append("3.ADD MONEY TO ACCOUNT")
                .append("\n")
                .append("4.TRANSFER MONEY FROM ACCOUNT")
                .append("\n")
                .append("5.ADMIN\n0.EXIT\nPress the adjacent number");
        System.out.println(screen);
    }

    private int showSubMenu() {
        int input;
        System.out.println("\nPress 6 to go to menu\nPress 0 to Exit");
        input = inputController.getIntInput();
        return input;
    }

    private void menuHandling(int input) {
        while (state) {
            switch (input) {
                case 1:
                    addAccountOperation();
                    input = showSubMenu();
                    break;
                case 2:
                    searchAccountOperation(" ");
                    input = showSubMenu();
                    break;
                case 3:
                    creditOperation();
                    input = showSubMenu();
                    break;
                case 4:
                    debitOperation();
                    input = showSubMenu();
                    break;
                case 5:
                    adminOperation();
                    input = showSubMenu();
                    break;
                case 6:
                    showMenu();
                    input = inputController.getIntInput();
                    break;
                case 0:
                    state = false;
                    break;
                default:
                    input = showSubMenu();
            }
        }
    }

    private void adminOperation() {
        System.out.println("1.Sort Accounts by ID\n2.Sort accounts by Balance");
        int input = inputController.getIntInput();
        while (true) {
            switch (input) {
                case 1:
                    Collections.sort(bank.getAccounts(), bank.getAccountComparison());
                    showAccountList(bank.getAccounts());
                    return;
                case 2:
                    Collections.sort(bank.getAccounts(), bank.getBalanceComparison());
                    showAccountList(bank.getAccounts());
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Wrong Input");
                    input = inputController.getIntInput();
            }
        }
    }

    private void addAccountOperation() {
        Account newAccount = inputController.inputOfCreatingAccount(bank.idGenerator());
        bank.addAccount(newAccount);
        System.out.println("SUCCESS!!! Account Created");
        System.out.println(newAccount.toString());
    }

    private Account searchAccountOperation(String searchType) {
        System.out.println("Type " + searchType + " Account Number : ");
        Account account = bank.searchAccount(inputController.getIntInput());
        if (account == null) {
            System.out.println("\nAccount doesn't exist");
            return null;
        } else {
            System.out.println(account.toString());
            return account;
        }
    }

    private void creditOperation() {
        Account account = searchAccountOperation(" ");
        if (account == null) {
            System.out.println("Could not add money");
            return;
        } else {
            System.out.println("Type the amount you want to add to your account");
            double creditAmount = inputController.getDoubleInput();
            if (creditAmount > 0) {
                account.credit(creditAmount);
                System.out.println(account.toString());
            } else {
                System.out.println("You have not added any money");
            }
        }
    }

    private void debitOperation() {
        Account accountToDebitFrom = searchAccountOperation("Source");
        if (accountToDebitFrom == null) {
            System.out.println("Could not transfer money");
        } else {
            double debitAmount;
            System.out.println("Type the amount you want to transfer");
            debitAmount = accountToDebitFrom.debit(inputController.getDoubleInput());
            if (debitAmount <= 0) {
                System.out.println("Transfer is not possible");
            } else {
                Account accountToTransferTo = searchAccountOperation("Destination");
                if (accountToDebitFrom.equals(accountToTransferTo) || accountToTransferTo == null) {
                    System.out.println("Transfer failed");
                } else {
                    accountToTransferTo.credit(debitAmount);
                    System.out.println("Transferred " + debitAmount + "TK to Account No. " + accountToTransferTo.getId() + "\n" + accountToTransferTo.toString());
                }
            }
        }
    }

    private void showAccountList(ArrayList<Account> list) {
        for (Account account : list) {
            System.out.println("ACCOUNT NO: " + account.getId() + " Holder Name: " + account.getHolderName() + " Balance: " + account.getBalance());
        }
    }

}

