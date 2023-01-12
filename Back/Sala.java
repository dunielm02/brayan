package Back;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sala {
    String nombre = "";
    List<Libro> lista_de_libros = new ArrayList<>();
    public Sala(String Nombre){
        this.nombre = Nombre;
    }
    public void addLibro(Libro l){
        this.lista_de_libros.add(l);
    }
    public String toString(){
        return this.nombre;
    }
    public List<String> listaMaterias(){
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(Libro l : this.lista_de_libros){
            set.add(l.getTitulo());
        }
        for(String i : set){
            list.add(i);
        }
        return list;
    }
}

