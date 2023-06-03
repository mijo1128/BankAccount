import java.util.Scanner;

public class CheckingAccount extends Account{

    public CheckingAccount(String name,String lastName, double deposit){
        super(name,lastName,deposit);
    }


    public void deposit(double amount){
            balance += amount;
            System.out.printf("$%.2f deposited%n\n", amount);
            System.out.printf("Updated balance: $%.2f %n\n", this.balance);
            this.log(amount, "ATM/BANK", "Deposit");

    }

    public void withdraw(double amount) {
            if ((amount) <= balance) {
                System.out.printf("$%.2f withdrawn from Account%n\n", amount);
                balance -= amount;
                this.log(amount, "ATM/BANK", "Withdraw");
                System.out.printf("Updated balance: $%.2f %n\n", this.balance);
            } else {
                System.out.println("Insufficient funds. You will be taken back to the main menu.\n");
            }
    }
}

