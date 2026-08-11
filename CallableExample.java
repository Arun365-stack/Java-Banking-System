import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
class CallableExample{	


		public static void main(String args[]){
	
		ExecutorService exService=Executors.newFixedThreadPool(2);



			Callable<String> task1=()->{
	
				String name="Bank Statement";
				return name;
				
			};

			Callable<Integer> task2=()->{
	
				Integer balance=10000;
					return balance;
				
			};

			Future<String> result=exService.submit(task1);

			Future<Integer>result1=exService.submit(task2);

			 try {
      				      System.out.println("Result = " + result.get() + " " +result1.get());
   					     } catch (Exception e) {
   					         System.out.println(e);
        						}


	
			exService.shutdown();

	}
}