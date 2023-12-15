import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1 – Open a Checking account");
            System.out.println("2 – Open Saving Account");
            System.out.println("3 – List Accounts");
            System.out.println("4 – Account Statement");
            System.out.println("5 – Deposit funds");
            System.out.println("6 – Withdraw funds");
            System.out.println("7 – Close an account");
            System.out.println("8 – Exit");
            
            System.out.println("Please enter your choice:");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = scanner.next();
                    System.out.println("Enter last name:");
                    String lastName = scanner.next();
                    System.out.println("Enter social security number (999-999-9999):");
                    String ssn = scanner.next();
                    System.out.println("Enter date of birth (MM-DD-YYYY):");
                    String dob = scanner.next();
                    System.out.println("Enter overdraft limit:");
                    double overdraftLimit = scanner.nextDouble();

                    bank.openCheckingAccount(firstName, lastName, ssn, dob, overdraftLimit);
                    break;
                case 2:
                    System.out.println("Enter first name:");
                    firstName = scanner.next();
                    System.out.println("Enter last name:");
                    lastName = scanner.next();
                    System.out.println("Enter social security number (999-999-9999):");
                    ssn = scanner.next();
                    System.out.println("Enter date of birth (MM-DD-YYYY):");
                    dob = scanner.next();

                    bank.openSavingAccount(firstName, lastName, ssn, dob);
                    break;
                case 3:
                    bank.listAccounts();
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine(); 
                    scanner.nextLine(); 
                    break;
                case 4:
                    System.out.println("Enter account number:");
                    int accountNumber = scanner.nextInt();
                    bank.accountStatement(accountNumber);
                    break;
                case 5:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextInt();
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    bank.depositFunds(accountNumber, depositAmount);
                    break;
                case 6:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextInt();
                    System.out.println("Enter the withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    bank.withdrawFunds(accountNumber, withdrawalAmount);
                    break;
                case 7:
                    System.out.println("Enter account number to close:");
                    accountNumber = scanner.nextInt();
                    bank.closeAccount(accountNumber);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }

        } while (choice != 8);

        System.out.println("Exiting the program.");
    }
}
