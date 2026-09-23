import java.util.Scanner;

//Bank Account
class Account {

    private String holderName;
    private double accountBalance;

    // Constructor
    public Account(String name, double balance) {
        holderName = name;
        accountBalance = balance;
    }
    //add money
    public void addMoney(double amount) {

        if (amount > 0) {
            accountBalance = accountBalance + amount;

            System.out.println("\nAmount Deposited: Rs " + amount);
            System.out.println("Deposit completed successfully!");

        } else {
            System.out.println("\nPlease enter a valid amount.");
        }
    }
    //remove money
    public void removeMoney(double amount) {

        if (amount <= 0) {
            System.out.println("\nInvalid withdrawal amount.");

        } else if (amount > accountBalance) {
            System.out.println("\nTransaction Failed!");
            System.out.println("Your account has insufficient balance.");

        } else {
            accountBalance = accountBalance - amount;

            System.out.println("\nAmount Withdrawn: Rs " + amount);
            System.out.println("Withdrawal completed successfully!");
        }
    }
    //show balance
    public void showBalance() {

        System.out.println("\n     ACCOUNT BALANCE     ");
        System.out.println("Available Balance: Rs " + accountBalance);
    }
    //show account details
    public void showDetails() {

        System.out.println("Account Holder: " + holderName);
        System.out.println("Current Balance: Rs " + accountBalance);
    }
}
public class SimpleBankingApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("       WELCOME TO BANK");

        //account holder name
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        //initial balance
        System.out.print("Enter initial deposit: Rs ");
        double initialAmount = input.nextDouble();

        while (initialAmount < 0) {
            System.out.print("Enter a valid initial amount: Rs ");
            initialAmount = input.nextDouble();
        }
        Account myAccount = new Account(name, initialAmount);

        int option;

        do {

            System.out.println("\n     MAIN MENU     ");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. Close Application");

            System.out.print("Select an option: ");
            option = input.nextInt();

            switch (option) {

                case 1:
                    System.out.print("Enter amount to deposit: Rs ");
                    double deposit = input.nextDouble();

                    myAccount.addMoney(deposit);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: Rs ");
                    double withdrawal = input.nextDouble();

                    myAccount.removeMoney(withdrawal);
                    break;
                case 3:
                    myAccount.showBalance();
                    break;
                case 4:
                    myAccount.showDetails();
                    break;
                case 5:
                    System.out.println("\nThank you for banking with us!");
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("\nInvalid option!");
                    System.out.println("Please select a number from 1 to 5.");
            }

        } while (option != 5);

        input.close();
    }
}