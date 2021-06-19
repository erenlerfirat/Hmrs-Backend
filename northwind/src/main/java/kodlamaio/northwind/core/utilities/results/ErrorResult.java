package kodlamaio.northwind.core.utilities.results;

public class ErrorResult extends Result {
	

		public ErrorResult() {
			super(false);
			// TODO Auto-generated constructor stub
		}
		public ErrorResult(boolean success,String message) {
			super(false,message);
			// TODO Auto-generated constructor stub
		}
			
}
