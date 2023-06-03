import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static HashMap<Integer,Transactions> transactions = new HashMap<>();
    public static void main(String[] args) {
        Scanner selection = new Scanner(System.in);
        System.out.println("""
                Welcome to your bank account.
                Lets get you started by setting up your Account.
                """);
        System.out.println("Enter your first name: ");
        String name = selection.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = selection.nextLine();
        double amount = Account.validNumber("How much would you like to deposit as your initial balance?");
        CheckingAccount checkingAcc = new CheckingAccount(name,lastName,amount);
        checkingAcc.log(amount,"Bank","Deposit");
        addToMap(checkingAcc.getAccountNumber(), checkingAcc);


        String input;
        do {
            System.out.println();
            System.out.println("Would you like to [D]eposit, [W]ithdraw, [L]og in a purchase, [V]iew account, [T]ransactions or [Q]uit?");
            input = selection.next().toUpperCase();
            switch (input) {
                case "D" -> checkingAcc.deposit(Account.validNumber("How much would you like to deposit?"));
                case "W" -> checkingAcc.withdraw(Account.validNumber("How much would you like to withdraw?"));
                case "L" -> checkingAcc.logPurchase();
                case "V" -> checkingAcc.viewAccount();
                case "T" -> checkingAcc.getTransactions();
                case "Q" -> System.out.println("Thank you for visiting.");
                default -> System.out.println("Please select one of the given choices");
            }
        } while(!input.equals("Q"));


    }

    public static void addToMap(int accountNo,Account account){

        accounts.put(accountNo,account);
    }


}
