package Back.Exception;

public class ExisteSalaException extends Exception {

    public ExisteSalaException() {
    }

    public String getMessage(){
        return "Este sala ya existe";
    }
    
}
