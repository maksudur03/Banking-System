import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
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
        int id =  random.nextInt(10000);
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
}
