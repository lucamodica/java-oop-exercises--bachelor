public class Cons extends List {
    private int elem;   // Elemento memorizzato
    private List next;  // Riferimento al nodo successore

    public Cons(int elem, List next) {
        this.elem = elem;
        this.next = next;
    }

    public String toString() {
        return elem + ", " + next.toString();
    }

    public List insert(int n, int x) {
        if(n != 0 && next == null){
            throw new IllegalArgumentException("Posizione illegale");
        }
        else if(n==0){
            return new Cons(x,this);
        }
        return new Cons(elem,next.insert(n-1, x));
    }
}
