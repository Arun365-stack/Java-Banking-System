class CurrentAccount extends BankAccount{

	
	private long overDraft;

	public CurrentAccount(long accNumber,String accName,double balance,long overDraft){
	
		super(accNumber,accName,balance);

			this.overDraft=overDraft;
	}

		public long getOverDraft(){

			return overDraft;
		}

/*	@Override
	protected boolean canWithdraw(double amount){

			return amount>0 && amount <= getBalance() + this.overDraft;
			} */

	@Override
	protected void validateWithdrawal(double amount) throws BankException{
	
			if(amount<0){
					throw new InvalidAmountException();
			}
			
			else if(amount <= getBalance() + this.overDraft){
	
					return;				}
			else{
					throw new OverDraftLimitExceeded();
				}
			

			//	super.validateWithdrawal(amount);

				
	}

	protected void maintainanceFee(){
	
				int monthlyMaintanceFee=250;
			withdraw(monthlyMaintanceFee);
			
		}
	
	@Override
	protected void processMonthEnd(){	
	
			 maintainanceFee();
			
		}

			@Override
public String toString() {
    return "Account Number: " + getAccNumber() +
           "\nAccount Name: " + getAccName() +
           "\nBalance: " + getBalance() +
		"\nOverdraft: " + overDraft;
}

	public static void main(String args[]){

			
			CurrentAccount ca=new CurrentAccount(1243,"Murugan",1000,10000);
					
					System.out.println(ca.getOverDraft());
					System.out.println(ca.getBalance());
					
try {
    ca.deposit(4000, "fun");
    ca.deposit(-5000, "funny");
} catch (BankException e) {
     System.out.println(e.getMessage());
}				System.out.println(ca.getBalance());
					System.out.println(ca.withdraw(7000));
					System.out.println(ca.getBalance());
					System.out.println(ca.withdraw(5000));
					System.out.println(ca.getBalance());



		}
	
}


