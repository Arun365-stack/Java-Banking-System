import java.io.IOException;
import java.io.FileReader;

class FileExample1{

	public static void main(String args[]){
	

		try{	FileReader reader=new FileReader("FileHandlingPractice.txt");

				int data;
				
			while((data=reader.read())!=-1){

				System.out.println((char) data);
					
				}

				reader.close();
			}

		catch(IOException e){	

				System.out.println(e);
			}


	}	

}