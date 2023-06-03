public class CheckingAccount extends Account{

    public CheckingAccount(double deposit){
        super(deposit);
    }


    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.printf("$%.2f deposited%n\n",amount);
        }else{
            System.out.println("A negative amount cannot be deposited");
        }
    }

    public void withdraw(double amount){
        if(amount > 0){
            if((amount) <= balance){
                System.out.printf("$%.2f withdrawn from Account%n\n",amount);
                balance -= amount;
            } else{
                System.out.println("Insufficient funds. You will be taken back to the main menu.\n");
            }
        }else{
            System.out.println("A negative amount cannot be withdrawn");
        }

    }
}

