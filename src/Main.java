import java.util.HashMap;
import java.util.Scanner;

public class Main {
    HashMap<Integer, Account> accounts = new HashMap<>();
    public static void main(String[] args) {
        Scanner selection = new Scanner(System.in);
        System.out.println("Welcome to your bank account. + " +
                "Lets get you started by setting up your Checking Account.");
        double amount = validNumber("How much would you like to deposit as your initial balance?");
        CheckingAccount checkingAcc = new CheckingAccount(amount);


        String input;
        do {
            System.out.println("Current balance: " + checkingAcc.getBalance());
            System.out.println("Account No: " + checkingAcc.getAccountNumber());
            if(checkingAcc.getOverdrafted()){
                System.out.println("Overdrafted");
            }
            System.out.println();
            System.out.println("Would you like to [D]eposit, [W]ithdraw, or [C]hange type? or [Q]uit");
            input = selection.next().toUpperCase();
            switch (input) {
                case "D" -> checkingAcc.deposit(validNumber("How much would you like to deposit?"));
                case "W" -> checkingAcc.withdraw(validNumber("How much would you like to withdraw?"));
                case "Q" -> System.out.println("Thank you for visiting.");
                default -> System.out.println("Please select one of the given choices");
            }
        } while(!input.equals("Q"));


    }
    public static double validNumber(String prompt){
        Scanner scanner = new Scanner(System.in);
        double i = -1;
        while(i < 0){
            System.out.println(prompt);
            String number = scanner.next();

            try{
                i = Double.parseDouble(number);
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid quantity");
                i = -1;
            }
        }
        return i;
    }

}
