//Classe di nodi generici GenericNode
public class GenericNode<T> {

    private GenericNode<T> next;
    private T elem;

    //Costruttore
    public GenericNode(T elem, GenericNode<T> next){
        this.elem = elem;
        this.next = next;
    }

    //Metodi getter
    public T getElem(){ return elem; }
    public GenericNode<T> getNext(){ return next; }

    //Metodi setter
    public void setElem(T elem){ this.elem = elem; }
    public void setNext(GenericNode<T> next){ this.next = next; }

    //Metodo equals
    public boolean equals(GenericNode<T> p){
        boolean res = true;
        GenericNode<T> n1 = getNext();
        GenericNode<T> n2 = p;

        //Verifica per il primo elemento
        if(getElem() != n2.getElem()){
            res = false;
        }

        while( (n1 != null || n2 != null) && res ){
            if( (!getElem().equals(n2.getElem())) || (n1 == null || n2 != null) || (n1 != null || n2 == null)){
                res = false;
            }
        }

        return res;
    }


}