package Back.Exception;

public class ClienteNotFound extends Exception{

    public ClienteNotFound() {
    }

    public String getMessage(){
        return "No se encontro al cliente";
    }

}