
package audiolistener2;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author xpc
 */
public class Usuario {
    String fecha;
    String nombre;
    Scanner teclado = new Scanner(System.in);
    
    
    public Usuario(){
        this.fecha = genereFecha();
        this.nombre = genereNombre();
    }
    /**
     * Metodo que le pide al usuario su nombre.
     * @return nombre dado por el usuario.
     */
    public String genereNombre(){
        System.out.println("Por favor, ingrese su nombre:");
        return teclado.nextLine();
    }
    /**
     * Metodo que genera la fecha del usuario, por medio de la clase SimpleDateFormat
     * se le da formato a la fecha dada por la clase Calendar.
     * @return retorna la fecha generada.
     */
    public String genereFecha(){
        String fecha = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss").format(Calendar.getInstance().getTime());
        return fecha;
    }
    /**
     * Metodo toString de la clase Usuario
     * @return retorna el nombre y la fecha del usuario.
     */
     @Override
    public String toString() {
        return this.nombre + " " + this.fecha;
    }
}
    

