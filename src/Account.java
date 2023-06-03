
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public abstract class Account {
    private final int accountNumber = generateAccountNumber();
    protected double balance;

    protected boolean overdrafted = false;

    public Account(double deposit) {
        this.balance = deposit;
    }



    public String getBalance() {
        String usCurrency = NumberFormat.getCurrencyInstance(Locale.US).format(this.balance);
        return usCurrency;
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
        StringBuilder string = new StringBuilder(6);
        for (int i = 0; i < string.capacity(); i++) {
            int randInt = random.nextInt(1,8);
            string.append(randInt);
        }
        return Integer.parseInt(string.toString());
    }


}
