import java.util.ArrayList;

class Account {
    private int accountNumber;
    private String firstName;
    private String lastName;
    private String SSN;
    protected double balance;
    private String accountStatus;
    protected ArrayList<TransactionS> Transactions;

    public Account(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = ssn;
        this.balance = 0.0;
        this.accountStatus = "Open";
        this.Transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        Transactions.add(new TransactionS("Credit", amount));
        System.out.println("Deposit successful. The new balance is: " + balance);
    }

    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            balance -= amount;
            Transactions.add(new TransactionS("Debit", amount));
            System.out.println("Withdrawal successful. The new balance is: " + balance);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds." + balance );
        }
    }

    public void printStatement() {
        for (TransactionS transaction : Transactions) {
            System.out.println(transaction.toString());
        }
        System.out.println("Balance: " + balance);
    }

    public void closeAccount() {
        if (balance > 0) {
            System.out.println("Deposits are not allowed on a closed account.");
            System.out.println("Withdrawals can be made until the account balance reaches zero.");
        } else if (balance < 0) {
            System.out.println("Withdrawals are not allowed on a closed account.");
            System.out.println("Deposits can be made as long as the account balance stays at zero or below.");
        }
        accountStatus = "Closed";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
               "\nName: " + firstName + " " + lastName +
               "\nSSN: " + SSN +
               "\nBalance: " + balance +
               "\nAccount Status: " + accountStatus +
               "\nTransactions: " + Transactions.toString() + "\n";
    }

}
