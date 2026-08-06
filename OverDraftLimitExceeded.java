
class OverDraftLimitExceeded extends BankException {

    public OverDraftLimitExceeded() {
        super("Overdraft limit exceeded.");
    }
}