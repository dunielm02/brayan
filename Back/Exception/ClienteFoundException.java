package Back.Exception;

public class ClienteFoundException extends Exception {

    public ClienteFoundException() {
    }
    
    public String getMessage(){
        return "Ya existe este cliente";
    }
}
