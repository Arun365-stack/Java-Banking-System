import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class FileExample2{
	

	public static void main(String args[]){

		Bank bankRef=new Bank();
	
		try{
				
			FileReader reader=new FileReader("FileHandlingPractice.txt");

			BufferedReader bufferedreader=new BufferedReader(reader);


				String line;

			while((line=bufferedreader.readLine())!=null){
	
				//	System.out.println(line);


					String[] lineArr=line.split(",");

				long accNumber=Long.parseLong(lineArr[0]);
				String type=lineArr[1];

				if(type.equals("SAVINGS")) {

				String name=lineArr[2];
				double balance=Double.parseDouble(lineArr[3]);
				int interestRate=Integer.parseInt(lineArr[4]);
				double perTransaction=Double.parseDouble(lineArr[5]);

				
					
   				 BankAccount account =
   			  new SavingsAccount(
       					     accNumber,
   					         name,
     					       balance,
      					      interestRate,
         				   perTransaction
       						 );
					
					bankRef.openAccount(account);

					//System.out.println(account);
				 }
				
				else if(type.equals("GOLD")) {

				String name=lineArr[2];
				double balance=Double.parseDouble(lineArr[3]);
				int interestRate=Integer.parseInt(lineArr[4]);
				double perTransaction=Double.parseDouble(lineArr[5]);
				int reward=Integer.parseInt(lineArr[6]);

				

  				  BankAccount account =
        					new GoldAccount(
       				          accNumber,
      					      name,
           				   balance,
     					       interestRate,
       					     perTransaction,
        				    reward
      					  );
					bankRef.openAccount(account);
					//System.out.println(account);
				 }

				else if(type.equals("CURRENT")) {

				String name=lineArr[2];
				double balance=Double.parseDouble(lineArr[3]);
				long overDraft=Long.parseLong(lineArr[4]);

					
				

  					  BankAccount account =
        				          new CurrentAccount(
       					     accNumber,
         				      name,
       					     balance,
        			              overDraft
       						 );
					bankRef.openAccount(account);
					//System.out.println(account);	
				}
				
				else if(type.equals("SALARY")) {

				String name=lineArr[2];
				double balance=Double.parseDouble(lineArr[3]);
				double minBalance=Double.parseDouble(lineArr[4]);


				
 					   BankAccount account =
    						    new SalaryAccount(
        						  accNumber,
          						  name,
           						  balance,
           						  minBalance
       						 );
						bankRef.openAccount(account);
						//System.out.println(account);
				}

				

			

				

				

				

			//System.out.println(accNumber+ " " +type+ " " +name+ " " +balance);
				}
					
					ArrayList<BankAccount>listOfAccounts5=bankRef.showAllAccounts();

			for (BankAccount account:listOfAccounts5){
	
					System.out.println(account.toString());
				}

			}

		catch(Exception e){
	
			System.out.println(e);

			}
		

		}


}
