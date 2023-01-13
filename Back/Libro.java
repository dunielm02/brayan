package Back;

import java.io.Serializable;

public class Libro implements Serializable{
    protected static  final long serialVersionUID = 5L;
    private String Titulo;
    private double valor = 0;
    private String Autor;
    private String ISBN;
    private String materia;
    private int cantidad = 0;
    String sinopsis = "";
    public Libro(String titulo, double valor, String autor, String iSBN, String Materia, String Sinopsis, int Cantidad){
        Titulo = titulo;
        this.valor = valor;
        Autor = autor;
        ISBN = iSBN;
        this.materia = Materia;
        this.sinopsis = Sinopsis;
        this.cantidad = Cantidad;
    }
    public void setCantidad(int Cantidad){
        this.cantidad = Cantidad;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public void add(int x){
        this.cantidad += x;
    }
    public boolean isNull(){
        return (this.cantidad == 0);
    }
    public String getTitulo() {
        return Titulo;
    }
    public String getSinopsis(){
        return this.sinopsis;
    }
    public void setSinopsis(String Sinopsis){
        this.sinopsis = Sinopsis;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getAutor() {
        return Autor;
    }
    public void setAutor(String autor) {
        Autor = autor;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public boolean equals(Object l){
        Libro l1 = (Libro) l;
        return this.Titulo.equalsIgnoreCase(l1.getTitulo());
    }
    public String toString(){
        return this.Titulo;
    }
}