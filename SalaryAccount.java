class SalaryAccount extends BankAccount{

	private double minBalance;

	public SalaryAccount(long accNumber,String accName,double balance,double minBalance){
	
		super(accNumber,accName,balance);
			this.minBalance=minBalance;
	}

	public double getMinBalance(){
	
			return minBalance;
		}

/*	@Override
	protected boolean canWithdraw(double amount){
	
		return getBalance()-amount >= minBalance;

	} */

	@Override
	protected void validateWithdrawal(double amount) throws BankException{
	
			if(getBalance()-amount < minBalance){
	
					throw new MinimumBalanceException();
				}

				super.validateWithdrawal(amount);


		}
	
	 @Override
	protected void  processMonthEnd(){
		
			System.out.println("hi");

		} 

@Override
public String toString() {
    return "Account Number: " + getAccNumber() +
           "\nAccount Name: " + getAccName() +
           "\nBalance: " + getBalance() +
		"\nMinimumBalance: " + minBalance;
}
	
}


