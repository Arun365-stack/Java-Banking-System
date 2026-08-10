
class ThreadPractice{


	public static void main(String args[]){
	

			System.out.println("main thread");

			Runnable task=()->{
	
				for(int i=0;i<=5;i++){
				System.out.println(i+" " +"Hello one thread");

						try{
						Thread.sleep(500);
							}
						catch (Exception e){
	
							System.out.println(e);
							}
					}

				};

			Runnable task1=()->{
				
				for(int i=0;i<=5;i++){
				System.out.println(i+" " +"Hello two thread");

						try{
						Thread.sleep(500);
							}
						catch (Exception e){
	
							System.out.println(e);
							}

					}

					
				};


			Thread t1=new Thread(task);
			Thread t2=new Thread(task1);

			
				t1.start();
				t2.start();
try {
    t1.join();
    t2.join();
} catch (InterruptedException e) {
    System.out.println(e);
}

			
			System.out.println("Hello main thread");
		}
	

}