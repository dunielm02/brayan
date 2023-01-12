package Back;
public class Pedido {
    private Libro libro;
    private int valor_pedido = 0;
    private int cantPedido = 0;
    private String vendedor = "";
    private boolean despachado = false;
    public Pedido(Libro libro, int cantPedido, String Vendedor) {
        this.libro = libro;
        this.cantPedido = cantPedido;
        this.valor_pedido = libro.getValor()*cantPedido;
        this.vendedor = Vendedor;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public int getValor_pedido() {
        return valor_pedido;
    }
    public void setValor_pedido(int valor_pedido) {
        this.valor_pedido = valor_pedido;
    }
    public int getCantPedido() {
        return cantPedido;
    }
    public void setCantPedido(int cantPedido) {
        this.cantPedido = cantPedido;
    }
    public void setDespachado(boolean flag){
        this.despachado = flag;
    }
    public boolean get_Despachado(){
        return this.despachado;
    }
    public String toString(){
        String s = "";
        if(this.despachado == false){
            s = "No Despachado";
        }
        else s = "Despachado";
        return this.libro.getTitulo() + " " + Integer.toString(this.cantPedido) + " " + s; 
    }
    public boolean equals(Pedido p){
        return this.libro.equals(p.getLibro());
    }
}
