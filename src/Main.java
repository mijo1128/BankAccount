import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner selection = new Scanner(System.in);
        System.out.println("Welcome to your bank account. + " +
                "Lets get you started by setting up your Checking Account.");
        double amount = validNumber(selection,"How much would you like to deposit?");
        CheckingAccount checkingAcc = new CheckingAccount(amount,false);
        System.out.println("Balance: " + checkingAcc.getBalance());
        System.out.println("Account Number: " + checkingAcc.getAccountNumber());
        checkingAcc.deposit(100);
        checkingAcc.withdraw(50);


//        do {
//            account.printBalance();
//            System.out.println("Account type: "+ account.type);
//            System.out.println("Would you like to [D]eposit, [W]ithdraw, or [C]hange type? or [Q]uit");
//            input = selection.next().toUpperCase();
//            switch (input) {
//                case "D" -> account.deposit();
//                case "W" -> account.withdraw();
//                case "C" -> account.changeType();
//                case "Q" -> System.out.println("Thank you for visiting.");
//                default -> System.out.println("Please select one of the given choices");
//            }
//        } while(!input.equals("Q"));


    }
    public static double validNumber(Scanner stdin, String prompt){
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

}
