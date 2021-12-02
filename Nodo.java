
package audiolistener2;

/**
 * 
 * @author xpc
 */
public class Nodo {
    String direccion;
    String nombre;
    Nodo next;
    
    public Nodo(){
        this.direccion = this.nombre = direccion;
        this.next = null;
    }
    /**
     * Getters and Setters
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    @Override
    public String toString(){
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      
}
