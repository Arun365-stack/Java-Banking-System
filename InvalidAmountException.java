class InvalidAmountException extends BankException {

    public InvalidAmountException() {
        super("Deposit amount must be greater than zero.");
    }
}