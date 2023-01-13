package Back;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String id="";
    private String tarjeta="";
    private List<Pedido> lista_pedidos = new ArrayList<>();
    public Cliente(String Id, String Tarjeta){
        this.id = Id;
        this.tarjeta = Tarjeta;
        lista_pedidos = new ArrayList<>();
    }
    public Cliente(){

    }
    public String getId() {
        return id;
    }
    public String getTarjeta(){
        return this.tarjeta;
    }
    public void setTarjeta(String Tarjeta){
        this.tarjeta = Tarjeta;
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
    public int removePedido(Pedido p){
        if(p.get_Despachado() == false){
            lista_pedidos.remove(p);
            return 0;
        }
        else return 1;
    }
    public void recoger(){
        this.lista_pedidos.clear();
    }
    public boolean equals(Object o){
        Cliente c = (Cliente) o;
        return this.id.equals(c.getId());
    }
}
