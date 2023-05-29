import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static Scanner in;
    private static float balance = 0; // initial balance to 0 for everyone
    private static int anotherTransaction;
    private static ArrayList<String> transactions = new ArrayList<String>();

    public static void main(String args[]) {
        in = new Scanner(System.in);

        // call our transaction method here
        transaction();
    }

    private static void transaction() {
        // here is where most of the work is
        int choice;

        System.out.println("Please select an option");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. Quit");

        choice = in.nextInt();

        switch (choice) {
            case 1:
                float amount;
                System.out.println("Please enter amount to withdraw: ");
                amount = in.nextFloat();
                if (amount > balance || amount == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction(); // ask if they want another transaction
                } else {
                    // they have some cash
                    // update balance
                    balance = balance - amount;
                    transactions.add("Withdraw: " + amount);
                    System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + "\n");
                    anotherTransaction();
                }
                break;

            case 2:
                // option number 2 is depositing
                float deposit;
                System.out.println("Please enter amount you would wish to deposit: ");
                deposit = in.nextFloat();
                // update balance
                balance = deposit + balance;
                transactions.add("Deposit: " + deposit);
                System.out.println("You have deposited " + deposit + " new balance is " + balance + "\n");
                anotherTransaction();
                break;

            case 3:
                // this option is to check balance
                System.out.println("Your balance is " + balance + "\n");
                anotherTransaction();
                break;

            case 4:
                // this option is to transfer money
                float transfer;
                System.out.println("Please enter the amount you would like to transfer: ");
                transfer = in.nextFloat();
                if (transfer > balance || transfer == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction(); // ask if they want another transaction
                } else {
                    // they have some cash
                    // update balance
                    balance = balance - transfer;
                    transactions.add("Transfer: " + transfer);
                    System.out.println("You have transferred " + transfer + " and your new balance is " + balance + "\n");
                    anotherTransaction();
                }
                break;

            case 5:
                // this option is to view transaction history
                if (transactions.size() == 0) {
                    System.out.println("No transactions yet.\n");
                } else {
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }
                    System.out.println("\n");
                }
                anotherTransaction();
                break;

            case 6:
                System.out.println("Thank you for using our ATM. Goodbye!");
                break;

            default:
                System.out.println("Invalid option:\n\n");
                anotherTransaction();
                break;
        }
    }

    private static void anotherTransaction() {
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        anotherTransaction = in.nextInt();
        if (anotherTransaction == 1) {
            transaction(); // call transaction method
        } else if (anotherTransaction == 2) {
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
}
