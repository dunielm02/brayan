public class Vendedor {
    String id = "";
    double cant = 0;
    public Vendedor(String Id){
        this.id = Id;
    }
    public void setCant(double x){
        this.cant = x;
    }
    public double getCant(){
        return this.cant;
    }
}
