
class TransactionS {
    private static int transactionIdCounter = 1;

    private int transactionId;
    private String type;
    private double amount;

    public TransactionS(String type, double amount) {
        this.transactionId = transactionIdCounter++;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return transactionId + " : " + type + " : " + amount;
    }
}