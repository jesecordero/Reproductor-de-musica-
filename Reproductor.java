
package audiolistener2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author xpc
 */


public class Reproductor {
   /**
    * Variables de instancia.
    * Son 'static' para que puedan ser llamadas en todo momento.
    */
   static Reproductor reproductor = new Reproductor();
   static Clip clip;
   
   public Reproductor(){
       
   }
   
   public static Reproductor getReproductor(){
       return reproductor;
   }
   /**
    * Metodo que recibe la direccion de un archivo, en este caso de musica.Convierte ese archivo de un objeto de tipo
    * clip para poder ser reproducido.
    * @param filepath Direccion de donde se encuentra el archivo.
    */
   public static void cargueArchivo(String filepath){
       try{
           File musicPath = new File(filepath);
           if(musicPath.exists() == true){
               AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
               clip = AudioSystem.getClip();
               clip.open(audioInput);
               System.out.println("[*].-Audio cargado.");
           }
           
       }catch(IOException e){
           System.out.println(e);
       } catch (UnsupportedAudioFileException ex) {
           Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("[!] Audio no soportado.");
       } catch (LineUnavailableException ex) {
           Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   
}
