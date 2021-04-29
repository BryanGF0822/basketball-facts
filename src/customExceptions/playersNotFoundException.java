package customExceptions;

public class playersNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public playersNotFoundException(){}
	
	@Override
	public String getMessage() {
		return "No se encontraron juagadores en la base de datos con los criterios de busqueda ingresados.";
		
	}
	
}
