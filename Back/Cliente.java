import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String id;
    private List<Pedido> lista_pedidos = new ArrayList<>();
    public Cliente(String Id){
        this.id = Id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Pedido> getLista_pedidos() {
        return lista_pedidos;
    }
    public void setLista_pedidos(List<Pedido> lista_pedidos) {
        this.lista_pedidos = lista_pedidos;
    }
    public void add_Pedido(Pedido p){
        this.lista_pedidos.add(p);
    }
    public void removePedido(Pedido p){
        lista_pedidos.remove(p);
    }
}
