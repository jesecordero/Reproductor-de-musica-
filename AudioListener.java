
package audiolistener2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author xpc
 * Clase AudioListener: Controlador de la lista Circular para el proyecto.
 */

public class AudioListener {
    ListaCircular lista; // Lista de memoria dinamica
    String ruta; // Ruta en disco duro
    File playlist; // Carpeta de audio
    static String path = "src\\audiolistener2\\AudioListener";
    
    
    
    /**
     * Constructor de la clase
     * @param ruta ruta de disco duro de donde toma los archivos a agregar a la lista circular.
     */
    public AudioListener(String ruta){
        this.lista = new ListaCircular();
        this.playlist = new File(ruta);
        this.ruta = ruta;
    }
    /**
     * Metodo que carga todos audios de la ruta dada en el constructor de la clase.
     */
    public void cargueArchivos(){
        for(File archivo:this.playlist.listFiles()){
            String nombre = archivo.getName();
            this.lista.add(nombre);
            System.out.println("Cancion con el nombre "+ nombre + " cargada!");
        }
        System.out.println("[*]Carga de canciones con exito!");
    }
    /**
     * Metodo que muestra la lista
     */
    public void muestreAudios(){
        this.lista.muestreLista();
    }
    /**
     * Metodo que se obtiene un elemento de la lista
     * @param posicion posicion en la que encuentra el elemento.
     * @return el Nodo que se busca
     */
    public Nodo getElement(int posicion){
        return this.lista.getElement(posicion, this.lista.inicio);
    }
    /**
     * Metodo que edita un elemento de la lista
     * @param elemento elemento a editar
     * @param nuevo nuevo nombre del Nodo.
     */
    public void editeElemento(Nodo elemento, String nuevo){
        this.lista.editeElemento(elemento, nuevo);
    }
    /**
     * Metodo que elimina un elemento de la lista.
     * @param n posicicon en la que se encuentra el elemento.
     */
    public void elimineElemento(int n){
        this.lista.elimineElemento(n);
    }
    /**
     * Metodo que se obtiene el tamano de la lista
     * @return tamano de la lista
     */
    public int getSize(){
        return this.lista.getTamano();
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        AudioListener music = new AudioListener(path);
        music.cargueArchivos();
        System.out.println("=======================================");
        music.muestreAudios();
        System.out.println("=======================================");
        System.out.println("Size: " + music.getSize());
        System.out.println("=======================================");
        System.out.println("Deme una cancion, de el numero \nCancion: ");
        int n = (Integer.parseInt(teclado.nextLine()))-1;
        System.out.println("La cancion es: " + music.getElement(n));
        
        
    }
    
    
    
}
