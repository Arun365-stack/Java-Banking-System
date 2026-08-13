class PaymentService{

	
		
		private Payment payment;


		
		public PaymentService(Payment payment){
	
			
			this.payment=payment;

				}


				public double getAmount(){
		
				return amount;

			}


		public boolean save(double amount){

				if(amount>0){
				payment.save(amount);
					return true;}
				else
					return false;
	
				}
	
		public static void main(String args[]){
	
				
				Payment payment=new CardPayment();

					PaymentService ps=new PaymentService(payment);
					

					System.out.println(ps.save(100));
				}

}