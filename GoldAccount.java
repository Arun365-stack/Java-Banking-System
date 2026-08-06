class GoldAccount extends SavingsAccount{
	
	private int reward;

	public GoldAccount(long accNumber,String accName,double balance,double interestRate,double perTransaction,int reward){
	

				super(accNumber,accName,balance,interestRate,perTransaction);

				this.reward=reward;
			
		}

	

	public int getReward(){
	
		return reward;

		}

	@Override
	protected void processMonthEnd(){
		
			 super.processMonthEnd();
				try{
				deposit(reward);}
				catch(BankException e){
	
					System.out.println(e);
					}

		}
		@Override
public String toString() {
    return "Account Number: " + getAccNumber() +
           "\nAccount Name: " + getAccName() +
           "\nBalance: " + getBalance() +
		"\nInterestRate: " + getInterestRate() +
		"\nPerTransactionLimit: " + getPerTransaction() +
		"\nReward: " + reward;
}

		public static void main(String args[]){
	
			GoldAccount ga=new GoldAccount(2321,"Sivaperuman",100000,7,50000,100);
		
			ga.processMonthEnd();
			System.out.println(ga.getBalance());	

			ga.withdraw(49000);
			System.out.println(ga.getBalance());	

		}
		
}