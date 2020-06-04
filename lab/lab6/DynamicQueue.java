// coda generica di dimensione dinamica, implementata come lista di Nodi
public class DynamicQueue<T> {
    // riferimento al primo nodo della lista, o null
    private GenericNode<T> first;
    // riferimento all'ultimo nodo della lista, o null
    private GenericNode<T> last;

    // INVARIANTE: 
    // vale: first==last==null,
    // oppure: first.getNext(). ... .getNext() == last 
    //         && last.getNext() == null              

    // costruttore: crea una coda vuota
    public DynamicQueue() {
        first = last = null;
    }

    // scrivi una rappresentazione della coda su terminale
    public void scriviOutput() {
        GenericNode<T> node = first;
        while (node != null) {
            System.out.print(node.getElem().toString() + " "); 
            node = node.getNext(); // successore
        }
        System.out.println();
    }

    // inserisci un nuovo elemento @x in fondo alla coda
    public void enqueue(T x) {
        // crea un nuvo nodo da inserire in fondo
        GenericNode<T> node = new GenericNode<>(x, null);
        if (empty()) // coda vuota
            first = last = node;
        else { // almeno un elemento
            last.setNext(node); // last -> node -> null
            last = node;
        }
        assert first!=null && last!=null && last.getNext()==null;
    }

    // rimuovi e ritorna l'elemento in testa alla coda
    public T dequeue() {
        assert !empty() : "non si puo' chiamare dequeue su una coda vuota.";
        T x = first.getElem();
        first = first.getNext();
        // se la coda si e' svuotata completamente, cambia anche last
        if (first == null)
            last = null;

        assert ((first==null && last==null) || 
                (first!=null && last!=null && last.getNext()==null));
        return x;
    }

    // ritorna true se la coda e' vuota
    public boolean empty() {
        return first == null;
    }

    // ritorna l'elemento in testa alla coda, senza rimuoverlo
    public T front() {
        assert !empty() : "non si puo' chiamare front su una coda vuota.";
        return first.getElem();
    }

    // ritorna la dimensione della coda
    public int size() {
        int n = 0;
        for (GenericNode<T> p = first; p != null; p = p.getNext())
            n++;
        return n;
    }

    // ritorna true se @x e' contenuto nella coda, false altrimenti
    public boolean contains(T x) {
        for (GenericNode<T> p = first; p != null; p = p.getNext())
            if (p.getElem().equals(x))
                return true; 
        return false;
    }

    //Metodo equals per il confronto di code generiche
    public boolean equals(DynamicQueue<T> q){
        boolean eq = true;

        //Controllo che le code siano della stessa lunghezza
        if(q.size() != size()){
            eq = false;
        }
        else{
            //Primo nodo della seconda lista
            GenericNode<T> q1 = first;
            //Primo nodo della seconda lista
            GenericNode<T> q2 = q.first;
            for (int i = 0; i < size() && eq; i++){
                if (!q1.getElem().equals(q2.getElem())){
                    eq = false;
                }
                q1 = q1.getNext();
                q2 = q2.getNext();
            }
        }

        return eq;
    }

}