import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Bank {
    private static Bank bank;
    private ArrayList<Account> accounts;
    private AccountComparison accountComparison;
    private BalanceComparison balanceComparison;

    private Bank() {
        setupBank();
    }

    public static Bank getBank(){
        if(bank == null){
            return new Bank();
        }else
            return null;
    }

    void setupBank() {
        accounts = new ArrayList<>();
        accountComparison = new AccountComparison();
        balanceComparison = new BalanceComparison();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public AccountComparison getAccountComparison() {
        return accountComparison;
    }

    public BalanceComparison getBalanceComparison() {
        return balanceComparison;
    }

    public void addAccount(Account account) {
        getAccounts().add(account);
    }

    public Account searchAccount(int id) {
        for (Account account : getAccounts()) {
            if (id == account.getId()) {
                return account;
            }
        }
        return null;
    }

    public int idGenerator() {
        Random random = new Random();
        int id = random.nextInt(10000);
        boolean hasRepeat = checkForRepetition(id, getAccounts());
        while (!hasRepeat) {
            id = random.nextInt(10000);
            hasRepeat = checkForRepetition(id, getAccounts());
        }
        return id;
    }

    public boolean checkForRepetition(long id, ArrayList<Account> accounts) {
        for (Account book : accounts) {
            if (id == book.getId()) {
                return false;
            }
        }
        return true;
    }

    private class AccountComparison implements Comparator<Account> {
        public int compare(Account account1, Account account2) {
            if (account1.getId() < account2.getId()) {
                return -1;
            } else if (account1.getId() > account2.getId()) {
                return 1;
            } else
                return 0;
        }
    }

    private class BalanceComparison implements Comparator<Account> {
        public int compare(Account account1, Account account2) {
            if (account1.getBalance() < account2.getBalance()) {
                return -1;
            } else if (account1.getBalance() > account2.getBalance()) {
                return 1;
            } else
                return 0;
        }
    }
}

