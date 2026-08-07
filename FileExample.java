import java.io.IOException;
import java.io.FileWriter;

	class FileExample{

	public static void main(String args[]){
	
	try{	FileWriter writer=new FileWriter("FileHandlingPractice.txt");

			writer.write("12313,SAVINGS,NallaSivam,50000,10,20000\n");
			writer.write("2321,GOLD,Sivaperuman,100000,7,50000,100\n");
			writer.write("1243,CURRENT,Murugan,1000,10000\n");
			writer.write("2321,GOLD,krishna,100000,7,50000,100\n");

			writer.close();


		}

	catch(IOException e){
	
		System.out.println(e);	

		}
	}

	}
	