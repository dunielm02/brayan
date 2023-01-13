package Back.Exception;

public class ExisteClienteException extends Exception {

    public ExisteClienteException() {
    }

    public String getMessage(){
        return "Ya existe este cliente";
    }
    
}
