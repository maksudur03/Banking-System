public class Account {
    private String holderName;
    private long id;
    private long NID;
    private double balance;
    private String accountType;

    public Account(String holderName, long id, long NID, double balance, String accountType) {
        this.holderName = holderName;
        this.id = id;
        this.NID = NID;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNID(long NID) {
        this.NID = NID;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    double debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return amount;
        } else
            return 0;
    }

    void credit(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "Account Details" +
                "\nAccount Holder Name=" + holderName +
                "\nAccount Number=" + id +
                "\nNID=" + NID +
                "\nbalance=" + balance +
                "\naccountType=" + accountType + "\n";
    }
}
