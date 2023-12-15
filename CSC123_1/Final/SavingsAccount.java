class SavingsAccount extends Account {
    public SavingsAccount(String firstName, String lastName, String ssn, String dob) {
        super(firstName, lastName, ssn);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds." + balance);
        }
    }

}