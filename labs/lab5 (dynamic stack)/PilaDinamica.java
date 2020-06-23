// Pila di dimensione variable di interi, 
// realizzata come lista concatenata di Nodi
public class PilaDinamica {
    // Riferimento al nodo contenente l'elemento in cima alla pila
    // Invariante: top==null se la pila e' vuota, top!= null altrimenti.
    private Node top;

    // Costruttore: crea una pila vuota
    public PilaDinamica() {
        this.top = null;
    }

    // Ritorna true se la pila e' vuota
    public boolean vuota() {
        return this.top == null;
    }

    // Ritorna true se la pila e' piena. 
    // Poiche' la pila ha dimensione dinamica, non puo' mai 
    // essere piena, a meno di finire la memoria
    public boolean piena() {
        return false;
    }

    // Aggiungi l'intero @x in cima alla pila
    public void push(int x) {
        top = new Node(x, top);
    }

    // Elimina l'elemento in cima alla pila, e ritornane il valore.
    public int pop() {
        assert !vuota() : "non si puo' chiamare il metodo pop() se la pila e' vuota.";
        int tmp = top.getElem();
        top = top.getNext();
        return tmp;
    }

    //Ritorna gli elementi della pila sotto forma di array
    public int[] toArray(){
        //Nodo di partenza
        Node n = top;
        //Counter del numero di elementi presenti, per dare una dimensione all'array
        int size = 0;

        //Ciclo per ricavare il numero di elementi
        while( n != null ){
            size++;
            n = n.getNext(); 
        }

        //Inserimento valori all'interno dell'array
        int[] res = new int[size];
        n = top;
        int ind = 0;
        while( n != null && ind < size){
            res[ind] = n.getElem();
            ind++;
            n = n.getNext();
        }

        return res;
    }
    
}