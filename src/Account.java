
import java.text.NumberFormat;
import java.util.*;

public abstract class Account {
    private String name;

    private String lastName;

    private final int accountNumber = generateAccountNumber();
    protected double balance;


    protected HashMap<Integer,Transactions> transactions = new HashMap<>();

    public Account(String name, String lastName, double deposit) {
        this.name = name;
        this.lastName = lastName;
        this.balance = deposit;
    }



    public String getBalance() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(this.balance);
    }

    public String getName(){
        return "Account Holder: " + this.name + " " + this.lastName;

    }
    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void getTransactions() {
        for(Map.Entry<Integer,Transactions> entry: this.transactions.entrySet()){
            String currency = NumberFormat.getCurrencyInstance(Locale.US).format(entry.getValue().amount);
            System.out.println("Transaction: " + entry.getKey()+
                    "   Location: " + entry.getValue().location + " " + entry.getValue().type + "    Amount " + currency);
        }
    }



    public abstract void deposit(double amount);

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

    public void log(double amount, String location,String type){
        Transactions transaction = new Transactions(amount,location,type);
        Integer transactionNumber = transactions.size() + 1;
        transactions.put(transactionNumber,transaction);
    }
    public void logPurchase(){
        Scanner input = new Scanner(System.in);
        System.out.println("Logging purchase");
        double amount = validNumber("Amount spent: ");
        System.out.println("Enter location of purchase");
        String location = input.nextLine();
        Transactions transaction = new Transactions(amount,location,"Withdrawal");
        Integer transactionNumber = transactions.size() + 1;
        transactions.put(transactionNumber,transaction);
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

    public void viewAccount(){
        System.out.println(getName());
        System.out.println("Account No: " + getAccountNumber());
        System.out.println("Current balance: " + getBalance());
    }



}
