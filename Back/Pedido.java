package Back;
public class Pedido {
    private Libro libro;
    private double valor_pedido = 0;
    private int cantPedido = 0;
    private Vendedor vendedor;
    private boolean despachado = false;
    public Pedido(Libro libro, int cantPedido, Vendedor Vendedor) {
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
    public double getValor_pedido() {
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
    public void setVendedor(Vendedor v){
        this.vendedor = v;
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
    public boolean equals(Object p){
        Pedido p1 = (Pedido) p;
        return this.libro.equals(p1.getLibro());
    }
}
