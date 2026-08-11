import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;
class AtomicIntegers{
	


			public static void main(String args[]){	


				AtomicInteger count = new AtomicInteger();

                                      

				ExecutorService ex=Executors.newFixedThreadPool(2);

				Callable<Integer> callable=()->{
	

						for(int i=0;i<=5;i++){
						 count.incrementAndGet();
						}
						
						return count.get();
							};
	

				Callable<Integer> callable1=()->{
	

						for(int i=0;i<=5;i++){
						 count.incrementAndGet();
						}
						
						return count.get();
							};


				Future<Integer> future=	ex.submit(callable);
				
				Future<Integer> future1= ex.submit(callable1);

					ex.shutdown();

						try{

					System.out.println(future.get()+ " " +future1.get());

							}

						catch(Exception e){	

							System.out.println(e);

							}

			}



	}