class SharedData{


	
	//	public boolean active=false;

		String data;

	public synchronized void waitForData(){
	
		//	while(!active){

			while(data==null){

			System.out.println(data);
	  try {
                wait();
			System.out.println(data);

            } catch (InterruptedException e) {
                System.out.println(e);
            }

			}	
			System.out.println("data is ready");
				}

		//

	public synchronized void produceData(){

	
			System.out.println("produced data and notify wait for data");

			//	active=true;
				data="Bank Transaction Completed";
				notify();
			
		}


}