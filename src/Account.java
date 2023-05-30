
import java.util.Random;
import java.util.Scanner;

public abstract class Account {
    private int accountNumber;
    protected double balance;

    public Account() {
    }
    public Account(int accountNumber, double deposit) {
        this.accountNumber = accountNumber;
        this.balance = deposit;
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

    public double validNumber(Scanner stdin, String prompt){
        double i = -1;
        while(i < 0){
            System.out.println(prompt);
            String input = stdin.nextLine();

            try{
                i = Double.parseDouble(input);
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid quantity");
                i = -1;
            }
        }
        return i;
    }

    public static int generateAccountNumber(){
        Random random = new Random();
        StringBuilder string = new StringBuilder(8);
        for (int i = 0; i < string.capacity(); i++) {
            //had to set the minimum to 0 because Parse Int removes leading zeroes
            //which was giving me some account numbers that were less than 8 digits long
            int randInt = random.nextInt(1,9);
            string.append(randInt);
            //just to view how the string is being built
            System.out.println(string);
        }
        //converting string to integer because class field is an integer
        return Integer.parseInt(string.toString());
        //this will be used to be passed to method to add to HashMap
    }
}
