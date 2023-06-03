
import java.util.Random;
import java.util.Scanner;

public abstract class Account {
    private final int accountNumber = generateAccountNumber();
    protected double balance;

    protected boolean overdrafted = false;

    public Account() {
    }
    public Account(double deposit,boolean overdrafted) {
        this.balance = deposit;
    }



    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public boolean getOverdrafted() {
        return this.overdrafted;
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

    public static int generateAccountNumber(){
        Random random = new Random();
        StringBuilder string = new StringBuilder(2);
        for (int i = 0; i < string.capacity(); i++) {
            int randInt = random.nextInt(1,8);
            string.append(randInt);
        }
        return Integer.parseInt(string.toString());
    }


}
