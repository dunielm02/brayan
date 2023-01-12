package Back;

public class Vendedor {
    String id = "";
    double cant = 0;
    public Vendedor(String Id){
        this.id = Id;
    }

    public boolean equals(Object o){
        Vendedor vendedor = (Vendedor)o;

        return this.id.equalsIgnoreCase(vendedor.getId());
    }

    public void setCant(double x){
        this.cant = x;
    }
    public double getCant(){
        return this.cant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
