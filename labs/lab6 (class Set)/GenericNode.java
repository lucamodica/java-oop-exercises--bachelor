// Nodo per realizzare liste concatenate generiche.
public class GenericNode<T> {
    // Elemento generico contenuto in questo nodo.
    private T elem;
    // Nodo successore, o null se e' l'ultimo nodo della lista concatenata.
    private GenericNode<T> next;

    // Crea un nuovo nodo con valore @elem e successore @next.
    public GenericNode(T elem, GenericNode<T> next) {
        this.elem = elem;
        this.next = next;
    }

    // Ritorna l'elemento contenuto in questo nodo.
    public T getElem() {
        return this.elem;
    }

    // Cambia l'intero contenuto nel nodo al nuovo valore @elem.
    public void setElem(T elem) {
        this.elem = elem;
    }

    // Ritorna il riferimento al nodo successore, oppure null se non c'e' un successore.
    public GenericNode<T> getNext() {
        return this.next;
    }

    // Cambia il riferimento al nodo successore con @next.
    public void setNext(GenericNode<T> next) {
        this.next = next;
    }
}
