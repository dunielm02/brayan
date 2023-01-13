package Back;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Back.Exception.ExisteClienteException;
import Back.Exception.ExisteSalaException;
import Back.Exception.ExisteVendedorException;
public class Sistema implements Serializable{
    protected static  final long serialVersionUID = 5L;
    private int cont;
    private ArrayList<Cliente> lista_de_clientes;
    private ArrayList<Sala> lista_de_salas;
    private ArrayList<Vendedor> vendedores;
    private int cantidadCancelados;
    public Sistema(){
        this.vendedores = new ArrayList<>();
        this.lista_de_clientes = new ArrayList<>();
        this.lista_de_salas = new ArrayList<>();
        this.cantidadCancelados = 0;
        this.cont = 1;
    }

    public ArrayList<Vendedor> getMejoresVendedores(){
        ArrayList<Vendedor> v = this.vendedores;
        v.sort(new Comparator<Vendedor>(){
           public int compare(Vendedor v1, Vendedor v2){
               if(v1.getCant() < v2.getCant()){
                return 1;
            }else{
                if( v1.getCant() == v2.getCant()){
                    return 0;
                }else{
                    return -1;
                }
            }
           }
        } 
            
        );

        return v;

    }

    public void addSala(Sala sala) throws ExisteSalaException{
        if(!this.lista_de_salas.contains(sala)){
            this.lista_de_salas.add(sala);
        }else{
            throw new ExisteSalaException();
        }
    }

    public void addCliente(Cliente cliente) throws ExisteClienteException {
        if(!this.lista_de_clientes.contains(cliente)){
            this.lista_de_clientes.add(cliente);
            cont++;
        }else{
            throw new ExisteClienteException();
        }        
    }

    public Cliente getCliente(String id){
        String tarjeta = id + Integer.toString((int)(Math.random() * 10));
        Cliente cliente = new Cliente(id, tarjeta);

        try {
            this.addCliente(cliente);
        } catch (ExisteClienteException e) {
            
        }

        return this.lista_de_clientes.get(this.lista_de_clientes.indexOf(cliente));
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

    public ArrayList<String> getListaMaterias(){
        ArrayList<String> materias = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (Sala sala : this.lista_de_salas) {
            for (Libro libro : sala.get_lista_de_libros()) {
                set.add(libro.getMateria());
            }
        }

        materias.addAll(set);

        return materias;
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

    public ArrayList<Libro> getLibrosMateria(String materia){
        ArrayList<Libro> libros = new ArrayList<>();
        Set<Libro> set = new HashSet<>();

        for (Sala sala: this.lista_de_salas) {
            for (Libro libro : sala.get_lista_de_libros()) {
                if(libro.getMateria().equalsIgnoreCase(materia)){
                    set.add(libro);
                }
            }
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

    public List<Sala> getLista_de_salas() {
        return lista_de_salas;
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

    public void setLista_de_clientes(ArrayList<Cliente> lista_de_clientes) {
        this.lista_de_clientes = lista_de_clientes;
    }

    public void setLista_de_salas(ArrayList<Sala> lista_de_salas) {
        this.lista_de_salas = lista_de_salas;
    }
}
