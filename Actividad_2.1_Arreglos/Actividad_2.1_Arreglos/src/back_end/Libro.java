/*
 Equipo #2
 CONTRERAS RODRIGUEZ JANIS ISABEL
 LIRA DOMINGUEZ BRYANT 
 PARRA GONZALEZ DIEGO ALBERTO
 */
package back_end;
import java.util.Objects;
/**
 *
 * @author coter
 */
public class Libro {
    private String titulo;//Atributos privados
    private String autor;
    private int anioPublicacion;

    public Libro() { //Constructor vacio
    }

    public Libro(String titulo, String autor, int anioPublicacion) {//Constructor con parametros
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }
//Get y Set por cada atribut///
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
   //Equals y el Hashcode sobreescritos
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, anioPublicacion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return anioPublicacion == libro.anioPublicacion && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor);
    }
//El toString
    @Override
    public String toString() {//Ahorita lo pongo mas presnetable
        return "Libro: " + "| Título: " + titulo + "| Autor:" + autor + "| Año:" + anioPublicacion;
    }
}//Final
