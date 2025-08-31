package CODVEDAINTERN;
import java.util.Scanner;

class L2Task3 {

    public static void main(String[] args)
     {
        BankAccount account = new BankAccount(100000000.0);
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Simple Banking Application");
        System.out.println("Current balance: $" + account.getBalance());

        while (true)
         {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) 
            {
                choice = scanner.nextInt();
                switch (choice) 
                {
                    case 1:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using our services. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
             else
             {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }
}

class BankAccount
 {
    private double balance;

    public BankAccount(double initialBalance)
     {
        this.balance = initialBalance;
    }

    public double getBalance()
     {
        return balance;
    }

    public void deposit(double amount)
     {
        if (amount > 0)
         {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
            System.out.println("New balance: $" + balance);
        } 
        else
         {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance)
         {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("New balance: $" + balance);
        } else if (amount > balance) 
        {
            System.out.println("Insufficient funds.");
        } else 
        {
            System.out.println("Invalid withdrawal amount. Please enter a positive number.");
        }
    }

    public void checkBalance()
     {
        System.out.println("Current balance: $" + balance);
    }
}
