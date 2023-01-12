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
    public String getNombre(){
        return this.nombre;
    }
    public void addLibro(Libro l){
        this.lista_de_libros.add(l);
    }
    public String toString(){
        return this.nombre;
    }
    public List<String> getListaMaterias(){
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
    public List<Libro> getListaPorTitulo(String Titulo){
        List<Libro> list = new ArrayList<>();
        for(Libro libro : this.lista_de_libros){
            if(libro.getTitulo().equalsIgnoreCase(Titulo)){
                list.add(libro);
            }
        }
        return list;
    }
    public List<Libro> getListaPorMateria(String Materia){
        List<Libro> list = new ArrayList<>();
        for(Libro libro : this.lista_de_libros){
            if(libro.getMateria().equalsIgnoreCase(Materia)){
                list.add(libro);
            }
        }
        return list;
    }
    public List<Libro> getListaPorMateriaTitulo(String Materia, String Titulo){
        List<Libro> list1 = getListaPorMateria(Materia);
        List<Libro> list2 = getListaPorTitulo(Titulo);
        if(list1.size() < list2.size()){
            for(Libro libro: list1){
                if(list2.contains(libro) == false){
                    list2.add(libro);
                }
            }
            return list2;
        }
        else{
            for(Libro libro : list2){
                if(list1.contains(libro) == false){
                    list1.add(libro);
                }
            }
            return list1;
        }
    }
    public boolean equals(Object o){
        Sala sala = (Sala) o;
        return this.nombre.equalsIgnoreCase(sala.getNombre());
    }
}

