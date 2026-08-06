import java.util.*;
class Bank{
	
	private ArrayList <BankAccount> accounts;

	
	public Bank(){
	
		accounts=new ArrayList<>();
	}

	

	public void openAccount(BankAccount account){
	
		accounts.add(account);
		}

	public void closeAccount(long accNumber)throws BankException {
	
	/*	for(BankAccount ba:accounts){	
				
				if(ba.getAccNumber()==accNumber){	
					
					accounts.remove(ba);
					
					}
	
				
					
					
			} */


		/*	Iterator<BankAccount> it = accounts.iterator();

					while (it.hasNext()) {
    					BankAccount ba = it.next();

   						 if (ba.getAccNumber() == accNumber) {
      					  it.remove();   // Safe
						return;
   					 }
				} */

			
			for(int i=0;i<accounts.size();i++){
			
				BankAccount account=accounts.get(i);
				if(account.getAccNumber()==accNumber){
	
					accounts.remove(account);
						return;
					}
				
				} 

				throw new BankException();





					/*	BankAccount ba=findBankAccount(accNumber);
		
			                       if (ba == null) {
        					throw new BankException();
   						 }
						accounts.remove(ba); */
		} 

	public BankAccount findBankAccount(long accnumber ){
	
		for(BankAccount account:accounts){
			
				if(account.getAccNumber()==accnumber){
									
				           return account;
					}
				
			}
		
			return null;
		} 

	public ArrayList<BankAccount> showAllAccounts(){
		
			return accounts;
			
	}

	public void transferMoney(long accNumFrom,long accNumTo,double amount)throws BankException{
	
				BankAccount fromAccount=findBankAccount(accNumFrom);
				BankAccount toAccount=findBankAccount(accNumTo);

				if (fromAccount == null || toAccount == null) {
                                throw new BankException();
                                    }
				else if(fromAccount.withdraw(amount)){

					try{
					toAccount.deposit(amount);}
					catch(BankException e){
	
						System.out.println(e);
						}}
				else throw new BankException();
					
		}
	public double getTotalBankBalance(){
		
			double total=0;
			for(BankAccount bas:accounts){
	
					total+=bas.getBalance();
				}
			return total;
				
		}

	public void prosessMonthEnd(){
	
			for(BankAccount bas:accounts){
	
					bas.processMonthEnd();
				}
			
			
		}

	public static void main(String args[]){
	
		Bank bankRef=new Bank();

		BankAccount bankaccount=new SavingsAccount(123,"NallaSivam",50000,10,20000);

			bankRef.openAccount(bankaccount);

		BankAccount bankaccount1=new GoldAccount(2321,"Sivaperuman",100000,7,50000,100);

			bankRef.openAccount(bankaccount1);
		
		BankAccount bankaccount3=new GoldAccount(2311,"krishna",100000,7,50000,100);

			bankRef.openAccount(bankaccount3);

			BankAccount acc=bankRef.findBankAccount(123);
			System.out.println(acc.toString());

			ArrayList<BankAccount>listOfAccounts=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts){
	
					System.out.println(account.toString());
				}

		try{
			bankRef.closeAccount(2311);
			}
		catch(Exception e){
	
			System.out.println(e);
			}

		ArrayList<BankAccount>listOfAccounts1=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts1){
	
					System.out.println(account.toString());
				}

		try{bankRef.transferMoney(2321,123,30000);}
			catch(Exception e){
	
					System.out.println(e);
				}

		ArrayList<BankAccount>listOfAccounts3=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts3){
	
					System.out.println(account.toString());
				}

			System.out.println(bankRef.getTotalBankBalance());

			bankRef.prosessMonthEnd();

		ArrayList<BankAccount>listOfAccounts4=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts4){
	
					System.out.println(account.toString());
				}

			
	}
	
}

