import jdk.jfr.Percentage;

public abstract class Account {
    private int accountNumber;
    protected double balance;

    public Account() {

    }
    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    //abstract

    /**
     @param amount amount to be deposited
     */
    public abstract void deposit(double amount);

    /**
     @param amount amount to be withdrawn
     */
    public abstract void withdraw(double amount);
}
