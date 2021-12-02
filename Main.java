
package audiolistener2;

import java.util.Scanner;

/**
 *Clase main o controlador del proyecto.
 * @author xpc
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        Usuario usuario = new Usuario();
        ReproductorGUIS music = new ReproductorGUIS();
        music.setCarpetaNombre(usuario.toString());
        music.setResizable(true);
        music.setVisible(false);
        music.setLocationRelativeTo(null);
        music.setName("Reproductor de Musica");
        
        System.out.println("Bienvenido/a");
        
        do{
            music.menuPrincipal();
            System.out.println("Opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            music.leaOpcion(opcion);
            
        }while(opcion !=7);
        System.out.println("Programa finalizado");
    }
}
