public class SavingsAccount extends Account {

    private double interestRate = 1.2;
    public SavingsAccount() {
        super();
    }

    public SavingsAccount(double deposit, double interestRate){
        super(deposit);
        this.interestRate = interestRate;
    }

    //getter function
    public double getInterestRate() {
        return this.interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateRate(){
        return balance * interestRate;
    }

    public void applyRate(){
        double interest = calculateRate();
        System.out.printf("Interest amount %.2f added to balance%n",interest);
        deposit(interest);
    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.printf("Amount %.2f deposited%n",amount);
            System.out.printf("Current Balance is: %.2f%n",balance);
        }else{
            System.out.println("A negative amount cannot be deposited");
        }
    }

    public void withdraw(double amount){
        if(amount > 0){
            if((amount) <= balance){
                System.out.printf("Amount %.2f withdrawn from Account%n",amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n",balance);
            }
        }else{
            System.out.println("A negative amount cannot be deposited");
        }

    }
}
