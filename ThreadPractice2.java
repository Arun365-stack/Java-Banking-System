class ThreadPractice2{


	public static void main(String args[]){
	
			SharedData sd=new SharedData();

			Thread t1=new Thread(()->{

				sd.waitForData();

				});

			Thread t2=new Thread(()->{

				sd.produceData();

				});

			t1.start();
			t2.start();

		}
	
	
}//