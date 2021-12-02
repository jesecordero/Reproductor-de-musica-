
package audiolistener2;

/**
 *  esVacia listo
 * getElement
 * add()
 * getSize listo
 * setSize
 * muestreLista
 * @author xpc
 */
public class ListaCircular {
    public Nodo inicio;
    public Nodo fin;
    public int tamano;
    
    /**
     * Constructor inicial de la ListaCircular
     */
    public ListaCircular(){
        this.inicio = this.fin = null;
        this.tamano = 0;  
    }
    /**
     * Metodo que verifica si la lista esta vacia o no, verificando si el primer elemento es nulo.
     * @return boolean false si no esta vacia, verdadero si no.
     */
    public boolean esVacia(){
        if(inicio == null){
            return true;
        }
        return false;
    }
    /**
     * Getter de la instancia tamano
     * @return tamano
     */
    public int getTamano(){
        return this.tamano;
    }
    /**
     * Coloca un nuevo tamano de la lista
     * @param n nuevo tamano
     */
    public void setTamano(int n){
        this.tamano = n;
    }
    
    /**
     * Metodo que anade un nuevo elemento a la lista, verifica si es el primer
     * elemento o si ya tiene al menos un elemento
     * @param direccion direccion del nodo.
     */
    public void add(String direccion){
        Nodo nuevo = new Nodo();
        nuevo.setDireccion(direccion);
        nuevo.setNombre(direccion);
    // Si es el primer elemento de la lista
        if(esVacia()){
            this.inicio = nuevo;
            this.fin = nuevo;
            fin.setNext(inicio);
            
        }else{
            fin.setNext(nuevo);
            nuevo.setNext(inicio);
            fin = nuevo;
        }
        this.tamano++; 
    }
    /**
     * Metodo que muestra la lista.
     */
    public void muestreLista(){
        Nodo iterator = inicio;
        int cont = 1;
        if(esVacia()){
            System.out.println("La lista es vacia");
        }
        else if(tamano == 1){
            System.out.println(inicio.getNombre());
        }
        else{
            while(iterator.next != inicio){ //Mientras no sea el ultimo elemento
                System.out.println("["+cont+"]"+iterator.getNombre());
                iterator = iterator.next;
                cont++;
            }
            System.out.println("["+cont+"]"+fin.getDireccion());
        }
    }
     /**
     * Metodo que edita un elemento de la lista
     * @param elemento elemento a editar
     * @param nuevo nuevo nombre del Nodo.
     */
    public void editeElemento(Nodo elemento, String nuevo){
        elemento.setNombre(nuevo);
    }
    /**
     * Metodo que elimina un elemento de la lista.
     * @param n posicicon en la que se encuentra el elemento.
     */
    public void elimineElemento(int n){
        if (n < 0 || n > this.getTamano()) 
            System.out.println("[!].-La posicion que digito no existe.");
        else if(n == 0)
            inicio = inicio.getNext();
        else{
            Nodo tmp = inicio;
            for (int i = 0; i < (n-1); i++) {
                tmp = tmp.getNext();
            }
            if (tmp.getNext() == fin) {
                tmp.setNext(inicio); // Se evalua la posibilidad de que el nodo que se busca sea el ultimo elemento, por lo cual si lo es, se hace el cambio de que en el nodo anterior su siguiente nodo sea el inicio, al ser una lista circular
                fin = tmp;
            }
            else{
                Nodo aux = tmp.getNext();
                tmp.setNext(aux.getNext());
            }
        }
        this.tamano--;
    }
    /**
     * Metodo para obtener un elemento de la lista de forma recursiva.
     * @param position posicion en la que se busca el elemento.
     * @param iterator nodo con el que que se empieza
     * @return retorna el nodo que se pidio.
     */
    public Nodo getElement(int position, Nodo iterator){
        if(position >= this.tamano){
            return null;
        }
        if(esVacia()){
            return null;
        }
        if(position == 0){
            return iterator;
        }
        iterator = iterator.next;
        return getElement((position-1),iterator);
    }
    
    
}
