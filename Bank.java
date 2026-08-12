import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.util.*;
class Bank implements Serializable{
	
	// private ArrayList <BankAccount> accounts;

	   private ConcurrentHashMap <Long,BankAccount> accounts;

	
	public Bank(){
	
		//accounts=new ArrayList<>();

			accounts=new ConcurrentHashMap<>();
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

/*	public void openAccount(BankAccount account){
	
		accounts.add(account);
		} */

	public void openAccount(long accNum,BankAccount account){
	
		accounts.put(accNum,account);
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

			
		/*	for(int i=0;i<accounts.size();i++){
			
				BankAccount account=accounts.get(i);
				if(account.getAccNumber()==accNumber){
	
					accounts.remove(account);
						return;
					}
				
				} 

				throw new BankException();    */


			
				
			  BankAccount removed = accounts.remove(accNumber);

    if (removed == null) {
        throw new BankException();
    }
						
						 
				
				
				



					/*	BankAccount ba=findBankAccount(accNumber);
		
			                       if (ba == null) {
        					throw new BankException();
   						 }
						accounts.remove(ba); */
		} 

	/* public BankAccount findBankAccount(long accnumber ){
	
		for(BankAccount account:accounts){
			
				if(account.getAccNumber()==accnumber){
									
				           return account;
					}
				
			}
		
			return null;
		} */


	 public BankAccount findBankAccount(long accnumber ){
	
			 return accounts.get(accnumber);

			
			/*	if(accounts.get(accNumber)){
									
				           return accounts.get(accnumber);
					}
				else
			return null; */
		}


	public ConcurrentHashMap<Long, BankAccount> showAllAccounts() {
    				return accounts;
				}

	public void transferMoney(long accNumFrom,long accNumTo,double amount)throws BankException{
	
				BankAccount fromAccount=findBankAccount(accNumFrom);
				BankAccount toAccount=findBankAccount(accNumTo);

				if (fromAccount == null || toAccount == null) {
                                throw new BankException();
                                    }
			/*	else if(fromAccount.withdraw(amount)){

					try{
					toAccount.deposit(amount);}
					catch(BankException e){
	
						System.out.println(e);
						}}
				else throw new BankException(); */

				    if (!fromAccount.withdraw(amount)) {
      					  throw new BankException();
   						 }

   						 try {
    					    toAccount.deposit(amount);

    							} catch (BankException e) {

      					  // Deposit failed → undo the withdrawal
      					  fromAccount.deposit(amount);

      							  throw e;
    							}

					
		}
/*	public double getTotalBankBalance(){
		
			double total=0;
			for(BankAccount bas:accounts){
	
					total+=bas.getBalance();
				}
			return total;
				
		} */

   /*     public double getTotalBankBalance(){
		
			double total=0;
			for(Long bas:accounts.keySet()){
	
					total+=accounts.get(bas).getBalance();
				}
			return total;
				
		} */

			public double getTotalBankBalance() {

   				 double total = 0;

  				  for (BankAccount account : accounts.values()) {
    				    total += account.getBalance();
    					}

    					return total;
					}



	/* public void prosessMonthEnd(){
	
			for(BankAccount bas:accounts){
	
					bas.processMonthEnd();
				}
			
			
		} */

		  public void processMonthEnd() {

   			 for (BankAccount account : accounts.values()) {
    			    account.processMonthEnd();
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


	/*	public <T extends BankAccount> ArrayList<T> findAccounts(Class<T> type) {
		
				ArrayList<T> accs=new ArrayList<>();


				for(BankAccount ba:accounts){
	

						//if(type.isInstance(ba)){
						if (ba.getClass() == type){

							accs.add(type.cast(ba));
						}
	
					}

				return accs;
				
                        } */


			public <T extends BankAccount> ArrayList<T> findAccounts(Class<T> type) {
		
				ArrayList<T> accs=new ArrayList<>();


				
					for(BankAccount ba:accounts.values()){
	

						//if(type.isInstance(ba)){
						if (ba.getClass() == type){

							accs.add(type.cast(ba));
						}
	
					}

				return accs;

				
                        } 

	/*	public  <T extends BankAccount> List<T> givesSpecificAccount(Class<T> type){
	
		         List<T>letsusLoopu     =  accounts.stream()
                                      .filter(account -> type.isInstance(account))
                                      .map(account -> type.cast(account))
                                      .collect(Collectors.toList());
		              	
			
			//		for(T sa:letsusLoopu){

			//			System.out.println(sa);

			//	     } 
						return letsusLoopu;
				}
                    */
		
			
	public static void main(String args[]){

		

	//	Bank bankRef=new Bank();
				
		
		Bank bankRef=Bank.loadBank();

		
				System.out.println("Style Style ma...");



	
	/*	
		BankAccount bankaccount=new SavingsAccount(123,"NallaSivam",50000,10,20000);

			//bankRef.openAccount(bankaccount);
			bankRef.openAccount(123,bankaccount);

		//	bankRef.saveBank(bankaccount);

		BankAccount bankaccount1=new GoldAccount(2321,"Sivaperuman",100000,7,50000,100);

			//bankRef.openAccount(bankaccount1);
			bankRef.openAccount(2321,bankaccount1);

		//	bankRef.saveBank(bankaccount1);

		BankAccount bankaccount3=new GoldAccount(2311,"krishna",100000,7,50000,100);

		//	bankRef.openAccount(bankaccount3);
			bankRef.openAccount(2311,bankaccount3);
		//	bankRef.saveBank(bankaccount3);

		BankAccount bankaccount4=new CurrentAccount(212,"Arun eshwar",10000,20000);
			//	bankRef.openAccount(bankaccount4);
				bankRef.openAccount(212,bankaccount4);

		//		bankRef.saveBank(bankaccount4);

		BankAccount bankaccount5=new SalaryAccount(214,"Arunachalam",210100,5000);
			//	bankRef.openAccount(bankaccount5);
				bankRef.openAccount(214,bankaccount5);

		//		bankRef.saveBank(bankaccount5);                                     

				bankRef.saveBank();                                                        
			//	bankRef.loadBank();	*/


	/*		List<GoldAccount> result =	bankRef.givesSpecificAccount(GoldAccount.class);

			System.out.println(result);    */

				
		ArrayList<SavingsAccount>savingsAccounts=bankRef.findAccounts(SavingsAccount.class);

				
					System.out.println(savingsAccounts);

				

		ArrayList<GoldAccount> gold =
                                          bankRef.findAccounts(GoldAccount.class);

				
					System.out.println(gold);

				

		ArrayList<SalaryAccount> salary =
                                          bankRef.findAccounts(SalaryAccount.class);

				
					System.out.println(salary);

				

		ArrayList<CurrentAccount> current =
                                          bankRef.findAccounts(CurrentAccount.class);

				
					System.out.println(current);  




			BankAccount acc=bankRef.findBankAccount(123);
			System.out.println(acc.toString());

		/*	ArrayList<BankAccount>listOfAccounts=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts){
	
					System.out.println(account.toString());
				} */

				ConcurrentHashMap<Long, BankAccount> allAccounts =
       					 bankRef.showAllAccounts();

					for (BankAccount account : allAccounts.values()) {
   					 System.out.println(account);
						}

		try{
			bankRef.closeAccount(2311);
			}
		catch(Exception e){
	
			System.out.println(e);
			}

	/*	ArrayList<BankAccount>listOfAccounts1=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts1){
	
					System.out.println(account.toString());
				} */


				ConcurrentHashMap<Long, BankAccount> allAccounts1 =
       					 bankRef.showAllAccounts();

					for (BankAccount account : allAccounts1.values()) {
   					 System.out.println(account);
						}


		try{bankRef.transferMoney(2321,123,30000);}
			catch(Exception e){
	
					System.out.println(e);
				}

	/*	ArrayList<BankAccount>listOfAccounts3=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts3){
	
					System.out.println(account.toString());
				} */


			ConcurrentHashMap<Long, BankAccount> allAccounts3 =
       					 bankRef.showAllAccounts();

					for (BankAccount account : allAccounts3.values()) {
   					 System.out.println(account);
						}



			System.out.println(bankRef.getTotalBankBalance());

			bankRef.processMonthEnd();

	/*	ArrayList<BankAccount>listOfAccounts4=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts4){
	
					System.out.println(account.toString());
				} */
			ConcurrentHashMap<Long, BankAccount> allAccounts4 =
       					 bankRef.showAllAccounts();

					for (BankAccount account : allAccounts4.values()) {
   					 System.out.println(account);
						}

				

			try{
			
			bankRef.withdraw(10000,212);
			bankRef.withdraw(1000,212);
				

			bankRef.withdraw(22000,212);}
			catch(Exception e){
	
				System.out.println(e);
				}
			
			

			try{	bankRef.deposit(10000,214);
				bankRef.deposit(-500,214);}
	
			catch(Exception e){
				System.out.println(e);
				}
	/*		ArrayList<BankAccount>listOfAccounts5=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts5){
	
					System.out.println(account.toString());
				} */

				ConcurrentHashMap<Long, BankAccount> allAccounts5 =
       					 bankRef.showAllAccounts();

					for (BankAccount account : allAccounts5.values()) {
   					 System.out.println(account);
						}



			ExecutorService executor=Executors.newFixedThreadPool(3);

					executor.submit(()->{

							try{
							bankRef.withdraw(3000,212);
								}
							catch(Exception e){
							System.out.println("Exception: " + e.getMessage());
								}
								});
					executor.submit(()->{
							try{
							bankRef.deposit(1000,212);
								}
								catch(Exception e){
							System.out.println("Exception: " + e.getMessage());
								}

								});
					executor.submit(()->{
							try{
							bankRef.withdraw(3000,212);
								}
								catch(Exception e){
							System.out.println("Exception: " + e.getMessage());
								}

								});

						executor.shutdown();


					
		   			try {
   				 executor.awaitTermination(10, TimeUnit.SECONDS);
					} catch (InterruptedException e) {
   					 System.out.println(e);
						}


			ConcurrentHashMap<Long, BankAccount> allAccounts6 =
       					 bankRef.showAllAccounts();

					for (BankAccount account : allAccounts6.values()) {
   					 System.out.println(account);
						}


					
	}
	
}

