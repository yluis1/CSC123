class CheckingsAccount extends Account {
    private double overdraftLimit;

    public CheckingsAccount(String firstName, String lastName, String ssn, String dob, double overdraftLimit) {
        super(firstName, lastName, ssn);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= -overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds." + balance);
        }
    }


}