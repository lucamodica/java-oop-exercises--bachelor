
/* 
 * Implementare un metodo moveMaxToEnd() che, in una lista di oggetti di tipo T, 
 * (dove T implementa Comparable) muove in ultima posizione l'elemento massimo
 *
 * Si assuma che l'elemento di un nodo non sia mai null.
 *
 * Seguono alcuni esempi di risultati attesi da moveMaxToEnd().
 *
 * lista  :
 * atteso :
 *
 * lista  : 1
 * atteso : 1
 *
 * lista  : 2, 1
 * atteso : 1, 2
 *
 * lista  : 2, 3, 1, 3, 2
 * atteso : 2, 1, 3, 2, 3
  *
 * Non e` consentito usare break o continue all'interno di
 * cicli.
 *
 * Non e` consentito modificare in alcun modo il codice al di fuori
 * del metodo "moveMaxToEnd".
 *
 */

class Node<T>{
    public T elem;
    public Node<T> next;

    public Node(T elem, Node<T> next) {
        this.elem=elem;
        this.next=next;
    }
}

class List<T extends Comparable<T>> {
    private Node<T> first;

    public List() {
        first = null;
    }
    public void insertFirst(T elem) {
        first = new Node<>(elem, first);
    }
    public String toString() {
        String s = "";
        for (Node<T> p = first; p != null; p = p.next) {
            if (p != first) 
                s += ", ";
            s += p.elem;
        }
        return s;
    }

    public void moveMaxToEnd() {
        
        Node<T> prev = first;

        if(prev!=null){
            Node<T> p = prev.next;
            T park = prev.elem;

            while(p!=null){
                if(prev.elem.compareTo(p.elem) > 0){
                    park = p.elem;
                    p.elem = prev.elem;
                    prev.elem = park;
                }
                prev = p;
                p = p.next;
            }
        }
        

    }
}


public class Main6 {
    public static void main(String[] args) {
        test(crea(), "");
        test(crea(1), "1");
        test(crea(2,1), "1, 2");
        test(crea(2, 3, 1, 3, 2), "2, 1, 3, 2, 3");        
    }

    private static void test(List<Integer> l, String atteso) {
        System.out.println("lista    : " + l);
        l.moveMaxToEnd();
        System.out.println("ottenuto : " + l);
        System.out.println("atteso   : " + atteso);
        System.out.println(l.toString().equals(atteso) ? "=== OK" : "=== ERRORE");
        System.out.println();
    }

    @SafeVarargs
    private static <T extends Comparable<T>> List<T> crea(T...v) {
        List<T> l = new List<>();
        for (int i = v.length - 1; i >= 0; i--)
            l.insertFirst(v[i]);
        return l;
    }
}
