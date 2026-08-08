import java.io.*;

import java.io.Serializable;
import java.util.*;
class Bank implements Serializable{
	
	private ArrayList <BankAccount> accounts;

	
	public Bank(){
	
		accounts=new ArrayList<>();
	}

	public void withdraw(double amount,long accNumber)throws BankException,NullPointerException{
	
		BankAccount bankaccount=findBankAccount(accNumber);

			if(bankaccount==null){
			throw new NullPointerException();
			}else{
			
			bankaccount.withdraw(amount);
			}
			
	}
	
	public void deposit(double amount,long accNumber)throws BankException,NullPointerException{
	
			BankAccount bankaccount=findBankAccount(accNumber);

			if(bankaccount==null){
			throw new NullPointerException();
			}else{
			try{
			bankaccount.deposit(amount);
				}
			catch(BankException e){
	
				System.out.println(e);
				}
			}

			
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

	public void saveBank(){
	
	
			try{
		FileOutputStream fos=new FileOutputStream("bank.dat");
		ObjectOutputStream ous=new ObjectOutputStream(fos);

			ous.writeObject(this);

			
			ous.close();
			}


		catch(Exception e){
	
				System.out.println(e);
			}
	}

	public static Bank loadBank(){
	
			try{
		FileInputStream fos=new FileInputStream("bank.dat");
		ObjectInputStream ous=new ObjectInputStream(fos);

			Bank bank=(Bank)ous.readObject();

				
			ous.close();

			return bank;
			}

			
		catch(Exception e){
	
				System.out.println(e);
			}
				return null;
		}

	public static void main(String args[]){

		

	//	Bank bankRef=new Bank();
				
		
		Bank bankRef=Bank.loadBank();

		

	/*	BankAccount bankaccount=new SavingsAccount(123,"NallaSivam",50000,10,20000);

			bankRef.openAccount(bankaccount);
		//	bankRef.saveBank(bankaccount);

		BankAccount bankaccount1=new GoldAccount(2321,"Sivaperuman",100000,7,50000,100);

			bankRef.openAccount(bankaccount1);
		//	bankRef.saveBank(bankaccount1);

		BankAccount bankaccount3=new GoldAccount(2311,"krishna",100000,7,50000,100);

		//	bankRef.openAccount(bankaccount3);
		//	bankRef.saveBank(bankaccount3);

		BankAccount bankaccount4=new CurrentAccount(212,"Arun eshwar",10000,20000);
				bankRef.openAccount(bankaccount4);
		//		bankRef.saveBank(bankaccount4);

		BankAccount bankaccount5=new SalaryAccount(214,"Arunachalam",210100,5000);
				bankRef.openAccount(bankaccount5);
		//		bankRef.saveBank(bankaccount5);                               */        

			//	bankRef.saveBank();
				bankRef.loadBank();	
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
			try{
			
			bankRef.withdraw(10000,212);
			bankRef.withdraw(19000,212);
				

			bankRef.withdraw(2000,212);}
			catch(Exception e){
	
				System.out.println(e);
				}
			
			

			try{	bankRef.deposit(10000,214);
				bankRef.deposit(-500,214);}
	
			catch(Exception e){
				System.out.println(e);
				}
			ArrayList<BankAccount>listOfAccounts5=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts5){
	
					System.out.println(account.toString());
				}


			

	}
	
}

