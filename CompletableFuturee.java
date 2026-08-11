import java.util.concurrent.*;

	
class CompletableFuturee{


	public static void main(String args[]){
	

	/*			ExecutorService exService=Executors.newFixedThreadPool(2);



				Callable<String> task1=()->{
	
				String name="Bank Statement";
				return name;
				
			};

			Callable<Integer> task2=()->{
	
				Integer balance=10000;
					return balance;
				
			};

			Future<String> future=exService.submit(task1); */

			CompletableFuture comFuture =CompletableFuture.supplyAsync(()->10000)
												.thenApply(balance->balance+3000)
												.thenAccept(result->System.out.println(result));


		/*	 try {
      				      System.out.println("future = " + future.get());
   					     } catch (Exception e) {
   					         System.out.println(e);
        						}


	
			exService.shutdown();*/


				
			

					

					

		}



	}