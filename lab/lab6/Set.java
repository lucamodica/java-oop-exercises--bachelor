//Classe Set
public class Set<T> {

    //Riferimento al primo nodo del set
    private GenericNode<T> first;
    //Dimensione del set
    private int size;

    //Costruttore
    public Set(){
        first = null;
        size = 0;
    }

    //Getter della dimensione del set
    public int size(){
        return size;
    }

    //Verifica del set vuoto
    public boolean empty(){
        return (first == null);
    }

    //Aggiunta di un elemento
    public void add(T elem){
        //Creazione nodo con il nuovo elemento
        GenericNode<T> n = new GenericNode<>(elem,null);

        //Aggiunta del nuovo nodo
        if(!empty()){
            n.setNext(first);
        }
        first = n;
        size++;
    }

    //Rimozionhe di un elemento
    public boolean remove(T elem){
        assert !empty() : "non si puo' chiamare remove su un set vuoto."; 

        //Variabile booleana che segnala la rimozione dell'elemento
        boolean done = false;

        //Ricerca dell'elemento nel set
        for(GenericNode<T> p = first; p != null && !done; p = p.getNext()){
            //Verifica che l'elemento sia nel nodo iniziale
            if(p.getElem().equals(elem)){
                first = p.getNext();
                done = true;
            }
            //Verifica per tutti gli altri casi
            else if(p.getNext() != null && p.getNext().getElem().equals(elem)){
                p.setNext(p.getNext().getNext());
                done = true;
            }
        }

        if(done){
            size--;
        }

        return done;
    }

    //Verifica che un elemento sia contenuto nel set
    public boolean contains(T elem){
        boolean result = false;

        //Ricerca dell'elemento
        for(GenericNode<T> p = first; p!= null && !result; p = p.getNext()){
            if(p.getElem().equals(elem)){
                result = true;
            }
        }

        return result;
    }

    //Verifica che un altro set sia contenuto in questo
    public boolean subsetOf(Set<T> s){
        boolean result = true;

        //Ricerca di ciascun elemento dell'altro set:
        //Se il puntantore di ques'ultimo varrà null,
        //significa che tutti gli elementi sono stati trovati
        for(GenericNode<T> p = first; p != null && result; p = p.getNext()){
            if(!s.contains(p.getElem())){
                result = false;
            }
        }
        
        return result;
    }

    //Verifica uguaglianza con un altro set
    public boolean eqaulsTo(Set<T> s){
        return size() == s.size() && subsetOf(s);
    }

    //Unione con un altro set
    public Set<T> union(Set<T> s){
        Set<T> unionSet = new Set<>();

        //Inserimento degli elementi del primo set
        for(GenericNode<T> p = first; p != null; p = p.getNext()){
            if( !unionSet.contains(p.getElem()) ){
                unionSet.add(p.getElem());
            }
        }
        //Inserimento degli elementi del secondo set
        for(GenericNode<T> p = s.first; p != null; p = p.getNext()){
            if( !unionSet.contains(p.getElem()) ){
                unionSet.add(p.getElem());
            }
        }

        return unionSet;
    }

    //Intersezione con un altro set
    public Set<T> intersection(Set<T> s){
        Set<T> intersSet = new Set<>();

        //Inserimento degli elementi nel set di intersezione, solo
        //se è contenuto in entrambi i set
        for(GenericNode<T> p = first; p != null; p = p.getNext()){
            if(s.contains(p.getElem())){
                intersSet.add(p.getElem());
            }
        }

        return intersSet;
    }

    //Stampa info sul set
    public void print(){
        System.out.print("Elementi del set: ");
        for(GenericNode<T> p = first; p != null; p = p.getNext()){
            System.out.print(p.getElem());
            if(p.getNext() != null){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}