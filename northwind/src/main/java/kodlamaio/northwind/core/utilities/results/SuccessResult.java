package kodlamaio.northwind.core.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true);
		// TODO Auto-generated constructor stub
	}
	public SuccessResult(boolean success,String message) {
		super(true,message);
		// TODO Auto-generated constructor stub
	}
	
	public SuccessResult(String message) {
		super(true,message);
		// TODO Auto-generated constructor stub
	}
}
