package customExceptions;

public class InvalidRangeException extends Exception{
	private static final long serialVersionUID = 1L;
	private String name;
	private int min;
	private int max;
	
	public InvalidRangeException(int min, int max, String name){
		this.name = name;
		this.min= min;
		this.max = max;
		
	}
	
	@Override
	public String getMessage() {
		return "The entered range for " + name + " is invalid or empty.\n" + "Validate that the range is in between " + min + " and " + max;
		
	}
	
}
