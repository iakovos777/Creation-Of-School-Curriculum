//IAKOVOS EVDAIMON 3130059

package ergasia1;

@SuppressWarnings("serial")
public class InvalidError extends RuntimeException {
	
	public InvalidError(){
		
	}
		

	public InvalidError(String message) {
			super(message);
	}

	public InvalidError(String message, Throwable cause) {
			super(message, cause);
	}

	public InvalidError(Throwable cause) {
		    super(cause);
	}
	

}
