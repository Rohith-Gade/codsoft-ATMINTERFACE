import java.util.Scanner;

class Account{
    private double accountBalance;

    public Account(double initialBalance){
        accountBalance = initialBalance;
    }

    public void withdraw(double amount){
        if(accountBalance>=amount){
            accountBalance -= amount;
            System.out.println("Withdraw of Rs."+amount+" is Successful!");
        }
        else{
            System.out.println("Insufficient Funds!");
        }
    }

    public void deposit(double amount){
        accountBalance += amount;
        System.out.println("Deposit of Rs."+amount+" is Successful!");
    }

    public double getAccountBalance(){
        return accountBalance;
    }

    
}

class ATM{
    private Account account;

    public ATM(Account account){
        this.account = account;
    }

    public void withdraw(double amount){
        account.withdraw(amount);
    }

    public void deposit(double amount){
        account.deposit(amount);
    }

    public void checkBalance(){
        double balance = account.getAccountBalance();
        System.out.println("Your Current Balance is Rs."+balance+"\n");
    }
}

public class ATMInterface{
    public static void main(String[] args){
        Account userAccount = new Account(2000);
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*********   ATM Menu:  *********");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter a choice from above options:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to Withdraw Rs. ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.println("Enter the amount to Deposit Rs. ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                
                case 4:
                    System.out.println("Thank You...!");
                    System.exit(0);
                    scanner.close();
                    
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }
        }
        
    }
}


    

