package customExceptions;

public class InvalidNameException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String name;
	
	public InvalidNameException(String name){
		this.name = name;
	}
	
	@Override
	public String getMessage() {
		return "The entered " + name + " is invalid or empty.";
		
	}
	
}
