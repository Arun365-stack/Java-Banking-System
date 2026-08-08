import java.io.Serializable;
abstract class BankAccount implements Serializable{
	
	protected long accNumber;
	protected String accName;
	private double balance;

	public BankAccount(long accNumber,String accName,double balance){
	
		this.accNumber=accNumber;
		this.accName=accName;
		this.balance=balance<0 ? 0 : balance;
	}

	public void deposit(double amount) throws InvalidAmountException{
	
	
		if(amount>0){
	
			this.balance+=amount;
			// return true;
		} else throw new InvalidAmountException();
			
		
              /*     else{
			System.out.println("deposit amount greater than zero ");
			return false;
		} */

	}

	protected void deposit(double amount,String description)throws InvalidAmountException{
	
			System.out.println(description);
			deposit(amount);
							
		}

	public boolean withdraw(double amount){
	
	/*	if(amount>0 && amount<=this.balance){
			this.balance-=amount;
			return true;
		}else {
			System.out.println("low balance so cant take amount which you entered");
			return false;
		}
	*/

		try{

		validateWithdrawal(amount); 

                 balance -= amount;
                 return true;
               }


		
		catch(BankException e){
	
			System.out.println(e);
			return false;

		}
		
            
		
	}


		protected void validateWithdrawal(double amount) throws BankException 	 {																	 
	
		
			if(amount<0){
	
				throw new InvalidAmountException();	
				}
			else if(amount>balance ){
	
					throw new LowBalanceException();
				}
							

		}

	/*	protected boolean canWithdraw(double amount){
			
			return amount>0 && amount<=this.balance;

		} */

		protected abstract void processMonthEnd(); /* {
				
				System.out.println("month end prosessing started");

			}*/

	public long getAccNumber(){
	
		return accNumber;
		}
	public String getAccName(){
		return accName;
		}
	public double getBalance(){
	
		return balance;
		}


	@Override
public String toString() {
    return "Account Number: " + accNumber +
           "\nAccount Name: " + accName +
           "\nBalance: " + balance;
}

	public static void main(String args[]){
	
	//	BankAccount account1=new BankAccount(00123,"Arunachalam",-1);

		BankAccount account1=new SavingsAccount(2112,"adadf",19000,3,20000);

				
				account1.withdraw(21000);
				try{account1.deposit(-5000,"SALARY");
				    	
						}
					catch( BankException e){
	
						 System.out.println(e.getMessage());
						}

			System.out.println(account1.getBalance()+" "+account1.getAccNumber()+ " " +account1.getAccName());

			BankAccount account2=new CurrentAccount(22112,"addadf",19000,20000);

					account2.withdraw(29000);
					account2.withdraw(29000);
			


			BankAccount account3=new SalaryAccount(212,"redadf",19000,2000);

						account3.withdraw(17000);
						account3.withdraw(17000);

			BankAccount account4=new GoldAccount(212,"redadf",19000,10,50000,100);

						account4.withdraw(17000);
						account4.withdraw(17000);

	/*	BankAccount[] accounts=new BankAccount[3];

			accounts[0]=new SavingsAccount(212,"adadf",30000,3,20000);
			accounts[1]=new CurrentAccount(2122,"adedadf",20040,2000);
			accounts[2]=new SalaryAccount(1321,"efqef",30000,5000);

			for(BankAccount bas:accounts){
	
					bas.withdraw(25000);
					bas.processMonthEnd();
					bas.deposit(50000,"Enjoy for fun");
					
			}
				System.out.println(accounts[0].getBalance());
				System.out.println(accounts[1].getBalance());
				System.out.println(accounts[2].getBalance());   */

		}
	
}

