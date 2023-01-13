package Back;

public class FaltanDespachadosException extends Exception{
    public FaltanDespachadosException(){
        super("Todos los pedidos no estan despachados");
    }
}
