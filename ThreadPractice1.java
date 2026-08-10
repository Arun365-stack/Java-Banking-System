class ThreadPractice1{
	

		int count=0;

		public synchronized void increment(){

			                  for (int i = 0; i < 100; i++) {
              
						count++;
                                    }  

			}
		
	public static void main(String args[]){

		
		
		ThreadPractice1 obj=new ThreadPractice1();
		

	/*	Runnable counting=() ->{

			  for (int i = 0; i < 10000; i++) {
                              
				obj.count++;
                                    }
		};  */

		Runnable counting=() ->{

			                              
				obj.increment();
                                    
		};  
		
		Thread th1=new Thread(counting);

		Thread th2=new Thread(counting);
	
	       			
		th1.start();
		th2.start();


    			try {
    			th1.join();
    			th2.join();
			} catch (InterruptedException e) {
			    System.out.println(e);
				}

		System.out.println(obj.count);
		System.out.println("Thread practice");
		
	}

	
}