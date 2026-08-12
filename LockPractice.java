import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LockPractice {

    private int count = 0;

    private final Lock lock = new ReentrantLock();

    public void increment() {

        lock.lock();

        try {

	    Thread.sleep(500);
            count++;
        }
	catch (InterruptedException e) {
        Thread.currentThread().interrupt();

    } 
        finally {
            lock.unlock();
        }
    }

	public void increment1() {

		if (lock.tryLock()) {
    try {
	Thread.sleep(1000);
        count++;
    }
	catch (InterruptedException e) {
        Thread.currentThread().interrupt();

    } 
	 finally {
        lock.unlock();
    }
} else {
    System.out.println("Someone else is using it");
}

}

    public int getCount() {
        return count;
    }


	
			public static void main(String[] args){
	
				LockPractice lockPractice=new LockPractice();
				ExecutorService exS=Executors.newFixedThreadPool(2);

				exS.submit(()->{
	
					lockPractice.increment();
							});
				exS.submit(()->{
	
					

					lockPractice.increment();
							});

				exS.submit(()->{
	
					lockPractice.increment1();
							});
				exS.submit(()->{
	


					lockPractice.increment1();
							});


				exS.shutdown();

		}
}