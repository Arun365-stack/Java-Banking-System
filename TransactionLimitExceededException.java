
class TransactionLimitExceededException extends BankException {

    public TransactionLimitExceededException() {
        super("Transaction limit exceeded.");
    }
}