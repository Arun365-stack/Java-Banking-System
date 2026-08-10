import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class ExecutorExample{

		
		
		

	public static void main(String args[]){
	

			ExecutorService service=Executors.newFixedThreadPool(2);


			Runnable task1=()->{
	
			System.out.println("one task");

				};

			Runnable task2 = () -> {
    				for (int i = 1; i <= 5; i++) {
    			        System.out.println("Task 1: " + i);

       				 try {
       				     Thread.sleep(500);
    				    } catch (InterruptedException e) {
      					      System.out.println(e);
     						   }
   						 }
						};

			Runnable task3=()->{
	
			System.out.println("second task");

				};

			Runnable task4=()->{
	
			System.out.println("second task");

				};


			service.submit(task1);

			service.submit(task2);


			service.submit(task3);

			service.submit(task4);

			service.shutdown();

	}
	

}