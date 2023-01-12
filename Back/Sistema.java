package Back;
import java.util.ArrayList;
import java.util.List;
public class Sistema {
    int cont = 1;
    public List<Cliente> lista_de_clientes = new ArrayList<>();
    public List<Sala> lista_de_salas = new ArrayList<>();
    int cantidadCancelados = 0;
    public Sistema(){

    }
    public boolean isCliente(Cliente c){
        return lista_de_clientes.contains(c);
    }
    public void addCliente(Cliente c){
        lista_de_clientes.add(c);
    }
    public List<Pedido> get_pedidos(){
        List<Pedido> list = new ArrayList<>();
        for(Cliente e: lista_de_clientes){
            for(Pedido p : e.getLista_pedidos()){
                list.add(p);
            }
        }
        return list;
    }
    public List<Pedido> get_pedidos_no_despachados(){
        List<Pedido> list = new ArrayList<>();
        for(Cliente e: lista_de_clientes){
            for(Pedido p : e.getLista_pedidos()){
                if(p.get_Despachado() == false) list.add(p);
            }
        }
        return list;
    }
    public List<Sala> get_lista_salas(){
        return this.lista_de_salas;
    }
}
