package Back.Exception;

public class ExisteVendedorException extends Exception {

    public ExisteVendedorException() {
    }

    public String getMessage(){
        return "Ya existe este vendedor";
    }
    
}
