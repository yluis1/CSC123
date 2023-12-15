import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class Bank {
    private static int accountNumberCounter = 1000; 
    private ArrayList<Account> accounts;
    
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void openCheckingAccount(String firstName, String lastName, String ssn, String dob, double overdraftLimit) {
        int age = calculateAge(dob);

        if (age < 18) {
            System.out.println("Checking account with overdraft limit cannot be opened. Customer must be 18 or older.");
        } else if (age < 16) {
            System.out.println("Checking account cannot be opened. Customer must be 16 or older.");
        } else {
            CheckingsAccount account = new CheckingsAccount(firstName, lastName, ssn, dob, overdraftLimit);
            initializeAccount(account);
        }
    }

    public void openSavingAccount(String firstName, String lastName, String ssn, String dob) {
        if (isValidAgeForSavingAccount(dob)) {
            SavingsAccount account = new SavingsAccount(firstName, lastName, ssn, dob);
            initializeAccount(account);
        } else {
            System.out.println("Customer is under 5 years old. Invalid age. ");
        }
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.println("List of accounts:");
            for (Account account : accounts) {
                System.out.println(account); 
            }
        }
    }

    public void accountStatement(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.printStatement();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void depositFunds(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawFunds(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdrawal completed.");
        } else {
            System.out.println("Account not found.");
        }
        
    }

    public void closeAccount(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.closeAccount();
            accounts.remove(account);
            System.out.println("Account closed. Current balance is " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void initializeAccount(Account account) {
        account.setAccountNumber(++accountNumberCounter);
        accounts.add(account);
        System.out.println("Thank you, the account number is " + account.getAccountNumber());
    }

    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    
    private boolean isValidAgeForSavingAccount(String dob) {
        int age = calculateAge(dob);
        if (age < 5) {
            System.out.println("Saving account cannot be opened. Customer must be at least 5 years old.");
            return false;
        }
        return true;
    }
    private int calculateAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
