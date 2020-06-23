/*
 * Implementare un metodo truncate che accetta in input una lista
 * di liste di numeri interi ll ed un numero non negativo x, e
 * tronca tutte le sottoliste di ll alla lunghezza x
 *
 * Seguono alcuni esempi di risultati attesi da truncate(2).
 *
 * lista  : []
 * atteso : []
 *
 * lista  : [[]]
 * atteso : [[]]
 *
 * lista  : [[1, 2], [2, 3, 5]]
 * atteso : [[1, 2], [2, 3]]
 *
 * Seguono alcuni esempi di risultati attesi da truncate(0).
 *
 * lista  : []
 * atteso : []
 *
 * lista  : [[]]
 * atteso : [[]]
 *
 * lista  : [[1, 2], [2, 3, 5]]
 * atteso : [[], []]
 *
 * Non e` consentito usare break o continue all'interno di
 * cicli.
 *
 * Non e` consentito modificare in alcun modo il codice al di fuori
 * del metodo "truncate".
 *
 */

class Node<T>{
    public T elem;
    public Node<T> next;

    public Node(T elem, Node<T> next){
        this.elem=elem;
        this.next=next;
    }

    public T getElem() {
        return elem;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setElem(T elem) {
        this.elem=elem;
    }
    public void setNext(Node<T> next) {
        this.next=next;
    }

    @Override
    public String toString(){
        String s = "[" + elem;
        for (Node<T> p = next; p != null; p = p.next) {
            s += ", ";
            s += p.elem;
        }
        s += "]";
        return s;
    }
}

public class Main7 {
    public static <T> void truncate(Node<Node<T>> ll, int x){
        int cont = 0;
        Node<Node<T>> ldl = ll;
        Node<T> l;

        while(ldl != null){

            
            if(x==0){
                ldl.setElem(null);
            }
            else{
                l = ldl.getElem();
                while(l != null ){
                    cont++;
                    if(cont==x){
                        l.setNext(null);
                    }
                    l = l.getNext();
                }
            }
            cont = 0;
            ldl = ldl.getNext();

        }
    }

    public static void main(String[] args) {
        test(crea(), 2, "null");
        test(crea(crea()), 2, "[null]");
        test(crea(crea(1,2),crea(2,3,5)), 2, "[[1, 2], [2, 3]]");
        test(crea(), 0, "null");
        test(crea(crea()), 0, "[null]");
        test(crea(crea(1,2),crea(2,3,5)), 0, "[null, null]");   
    }

    private static <T> void test(Node<Node<T>> l, int x, String atteso) {
        System.out.println("lista    : " + l);
        truncate(l, x);
        System.out.println("ottenuto : " + l);
        System.out.println("atteso   : " + atteso);
        if (l!=null)
            System.out.println(l.toString().equals(atteso) ? "=== OK" : "=== ERRORE");
        else
            System.out.println(atteso.equals("null") ? "=== OK" : "=== ERRORE");
        System.out.println();
    }

    @SafeVarargs
    private static <T> Node<T> crea(T...v) {
        Node<T> l = null;
        for (int i = v.length - 1; i >= 0; i--)
            l=new Node<>(v[i],l);
        return l;
    }
}

