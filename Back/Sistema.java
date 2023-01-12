package Back;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Back.Exception.ExisteVendedorException;
public class Sistema {
    public int cont = 1;
    public List<Cliente> lista_de_clientes = new ArrayList<>();
    public List<Sala> lista_de_salas = new ArrayList<>();
    private ArrayList<Vendedor> vendedores;
    int cantidadCancelados = 0;
    public Sistema(){
        this.vendedores = new ArrayList<>();
    }

    public void addVendedor(Vendedor vendedor) throws ExisteVendedorException{
        if(!this.vendedores.contains(vendedor)){
            this.vendedores.add(vendedor);
        }else{
            throw new ExisteVendedorException();
        }        
    }

    public Vendedor getVendedor(String id){
        Vendedor vendedor = new Vendedor(id);

        try {
            this.addVendedor(vendedor);
        } catch (ExisteVendedorException e) {
            
        }

        return this.vendedores.get(this.vendedores.indexOf(vendedor));
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
    public ArrayList<Libro> getLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        Set<Libro> set = new HashSet<>();
        
        for (Sala sala : this.lista_de_salas) {
            set.addAll(sala.lista_de_libros);
        }

        libros.addAll(set);

        return libros;        
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public List<Cliente> getLista_de_clientes() {
        return lista_de_clientes;
    }

    public void setLista_de_clientes(List<Cliente> lista_de_clientes) {
        this.lista_de_clientes = lista_de_clientes;
    }

    public List<Sala> getLista_de_salas() {
        return lista_de_salas;
    }

    public void setLista_de_salas(List<Sala> lista_de_salas) {
        this.lista_de_salas = lista_de_salas;
    }

    public ArrayList<Vendedor> getVendedores() {
        return this.vendedores;
    }

    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public int getCantidadCancelados() {
        return cantidadCancelados;
    }

    public void setCantidadCancelados(int cantidadCancelados) {
        this.cantidadCancelados = cantidadCancelados;
    }

}
