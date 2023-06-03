public class CheckingAccount extends Account{
    //default transcation fee

    //defualt constructor
    public CheckingAccount() {
        super();
    }

    public CheckingAccount(double deposit,boolean overdrafted){
        super(deposit,overdrafted);
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

