// "We built a well-encapsulated parent class, and then we reused it through inheritance without breaking its encapsulation."

class SavingsAccount extends BankAccount implements InterestBearing{

	 private double perTransaction;
         private double interestRate;

	public SavingsAccount(long accNumber,String accName,double balance,double interestRate,double perTransaction){
	
		super(accNumber,accName,balance);

		this.interestRate=interestRate;
		this.perTransaction=perTransaction;
		
	}

	public double getPerTransaction(){
	
		return perTransaction;
	}

	public double getInterestRate(){
	
		return interestRate;
	}

	@Override
	public void calculateInterest() {
		double balance = getBalance();
		double interest= balance * interestRate/100;
			try{
			deposit(interest);}
			catch(BankException e){
		
				System.out.println(e);
					}
		//	return interest;
			
			
	}

	@Override
	protected void processMonthEnd(){

		//	super.processMonthEnd();
			calculateInterest();
			
			

	}

/*	@Override
	protected boolean canWithdraw(double amount){


		if(amount<=perTransaction){
		super.withdraw(amount);
		}else{
		  return false;	
		}
	

	

		//return amount<=getPertransaction() && super.canWithdraw(amount); 
	} */

	@Override
	protected void validateWithdrawal(double amount) throws BankException{
	
			if(
			    amount>getPerTransaction()){
	
					throw new TransactionLimitExceededException();
				}
				
					
					super.validateWithdrawal(amount);
	

					

		}

	@Override
public String toString() {
    return "Account Number: " + getAccNumber() +
           "\nAccount Name: " + getAccName() +
           "\nBalance: " + getBalance() +
		"\nInterestRate: " + interestRate +
		"\nPerTransactionLimit: " + perTransaction;
}



	public static void main(String args[]){

			SavingsAccount sa=new SavingsAccount(123,"NallaSivam",50000,5,20000);
					
					System.out.println(sa.getBalance());
					//System.out.println(sa.calculateInterest());

					 InterestBearing ib=new SavingsAccount(12313,"NallaSivammm",50000,10,20000);
					          ib.calculateInterest();
						  sa.calculateInterest();
					System.out.println(sa.getBalance());
					SavingsAccount sa1=(SavingsAccount)ib;
						System.out.println(sa1.getBalance());


					System.out.println(sa.withdraw(15000));
					System.out.println(sa.getBalance());

			SavingsAccount[]sas=new SavingsAccount[3];
					
					for(int i=0;i<3;i++){
	
						sas[i]=new GoldAccount(233233,"settherg",10000,7,9000,100);
					}

					for(SavingsAccount s:sas){
	
						s.processMonthEnd();
						System.out.println(s.getBalance());
						s.withdraw(8999);
						System.out.println(s.getBalance());

					}
					

	}
	
}

