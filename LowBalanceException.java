class LowBalanceException extends BankException {

    public LowBalanceException() {
        super("Insufficient balance.");
    }
}