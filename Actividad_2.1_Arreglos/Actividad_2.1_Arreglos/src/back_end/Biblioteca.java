/*
 Equipo #2
 CONTRERAS RODRIGUEZ JANIS ISABEL
 LIRA DOMINGUEZ BRYANT 
 PARRA GONZALEZ DIEGO ALBERTO
 */
package back_end;
import java.util.Arrays;
/**
 *
 * @author coter
 */
public class Biblioteca {
    private Libro[] libros;

//Constructores, el vacio, el que tiene parametros y el que dice que tiene que tener capacidad?
    public Biblioteca() {
    }

    public Biblioteca(Libro[] libros) {
        this.libros = libros;
    }
    
    public Biblioteca(int capacidad) {
        if (capacidad <= 0){
            throw new IllegalArgumentException("La capacidad de la biblioteca debe ser mayor que cero.");
        }else if(capacidad > 0){
            this.libros = new Libro[capacidad];
        }
    }
// get and set //
    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

//Creo que esto tambien va, por lo que dijo el porofe en clase
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Arrays.deepHashCode(this.libros);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Biblioteca other = (Biblioteca) obj;
        return Arrays.deepEquals(this.libros, other.libros);
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "libros=" + libros + '}';
    }    
    
//Métodos que estan en la lista de moodle 
    public String crearBiblioteca(int capacidad){
        if (capacidad <= 0) { //Validar capacidad mayor que cero.
            return "Error: La capacidad debe ser mayor que cero.";
        }
        this.libros = new Libro[capacidad];//Inicializar el arreglo.
        return "Biblioteca creada exitosamente con capacidad para " + capacidad + " libros.";
    }
    
    public String mostrarLibros(){
        String mostrar = "";
        if (libros == null){ //Verificar que la biblioteca exista
            return "Error: La biblioteca no ha sido creada.";
        }else if (libros != null){
        mostrar = "=== CONTENIDO DE LA BIBLIOTECA ===\n";    
            for(int i = 0; i < libros.length; i++){//Recorrer el arreglo completo
                if(libros[i] != null){
                    mostrar = mostrar + "[" + i + "] " + libros[i].toString() + "\n";//Mostrar cada libro utilizando toString
                }else if(libros[i] == null){
                    mostrar = mostrar + "[" + i + "] [Posición vacía]\n";//Indicar posiciones vacías
                }
            }
        } 
        return mostrar;
    }
    
    public String agregarLibro(Libro libro, int indice){
        if (libros == null) { // Validar que la biblioteca exista
            return "Error: La biblioteca no ha sido creada.";
        }
        if (libro == null) { 
            return "Error: El libro no puede ser nulo.";
        }
        if (indice < 0 || indice >= libros.length) { //Validar que el índice esté dentro del rango permitido
            return "Error: El índice " + indice + " está fuera de rango (0 a " + (libros.length - 1) + ").";
        }
        if (libros[indice] != null) {//pa verificar que no este ocupado ya
            return "Error: La posición " + indice + " ya está ocupada por otro libro.";
        }

        libros[indice] = libro;//Asignar el objeto al arreglo en la posición indicada
        return "Libro '" + libro.getTitulo() + "' agregado correctamente en la posición " + indice + ".";
    }
    
    public String mostrarLibroPorIndice(int indice){
        if (libros == null) { //Validar que la biblioteca exista
            return "Error: La biblioteca no ha sido creada.";
        }
        if (indice < 0 || indice >= libros.length) { //Validar que el índice esté dentro del rango permitido.
            return "Error: El índice " + indice + " está fuera de rango (0 a " + (libros.length - 1) + ").";
        }
        if (libros[indice] == null) { // Y que no sea nulo
            return "La posición " + indice + " se encuentra vacía.";
        }
        //Retornar el libro almacenado en esa posición.
        return "Libro en la posición " + indice + ":\n" + libros[indice].toString();
    }
    
    public String modificarLibro(int indice, Libro libro){
        if (libros == null) { //Validar que la biblioteca exista
            return "Error: La biblioteca no ha sido creada.";
        }
        if (libro == null) { //Validar que exista un libro en esa posición
            return "Error: El libro no puede ser nulo.";
        }
        if (indice < 0 || indice >= libros.length) { // Validar que el índice esté dentro del rango permitido
            return "Error: El índice " + indice + " está fuera de rango (0 a " + (libros.length - 1) + ").";
        }
        if (libros[indice] == null) { //Si está vacío, pues no hay objeto para modificar
            return "Error: No existe ningún libro en la posición " + indice + " para modificar.";
        }
        libros[indice] = libro;//Reemplazar el objeto en la posición indicada
        return "El libro en la posición " + indice + " fue modificado correctamente.";
    }
    
    public String eliminarLibro(int indice){
        if (libros == null) { //Validar que la biblioteca exista
            return "Error: La biblioteca no ha sido creada.";
        }
        if (indice < 0 || indice >= libros.length) {//Validar que el índice esté dentro del rango permitido
            return "Error: El índice " + indice + " está fuera de rango (0 a " + (libros.length - 1) + ").";
        }
        if (libros[indice] == null) {
            return "Error: La posición " + indice + " ya está vacía.";
        }

        String tituloEliminado = libros[indice].getTitulo();// esto nomas pal msj final
        libros[indice] = null; //Asignar null a la posición correspondiente
        return "El libro '" + tituloEliminado + "' en la posición " + indice + " fue eliminado correctamente.";
    }
    
    public String destruirBiblioteca(){//Asignar null al arreglo interno.
        if (libros == null) {
            return "Error: La biblioteca no ha sido creada o ya fue destruida.";
        }
        libros = null; //Liberar todas las referencias almacenadass
        return "La biblioteca ha sido destruida y todas sus referencias fueron liberadas.";
    }   
}//Final
