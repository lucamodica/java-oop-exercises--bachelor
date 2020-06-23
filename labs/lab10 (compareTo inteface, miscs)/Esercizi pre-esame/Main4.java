/*
 * Implementare un metodo addOdd che accetta in input
 * una lista di liste di numeri interi, e, in ogni lista interna, aggiunge
 * l'elemento n+1 immediatamente dopo ogni elemento n pari.
 *
 * Si assuma che:
 * 1) la lista vuota sia rappresentata dal valore null;
 * 2) gli elementi dei nodi delle liste interne non siano mai null.
 *
 * Seguono alcuni esempi di risultati attesi da addOdd.
 *
 * lista  : []
 * atteso : []
 *
 * lista  : [[]]
 * atteso : [[]]
 *
 * lista  : [[1,2],[]]
 * atteso : [[1,2,3],[]]
 *
 * lista  : [[],[1,2]]
 * atteso : [[],[1,2,3]]
 *
 * lista  : [[1],[2]]
 * atteso : [[1],[2,3]]
 *
 * lista  : [[2],[1]]
 * atteso : [[2,3],[1]]
 *
 * lista  : [[1,2],[],[3,4,5,6,6]]
 * atteso : [[1,2,3],[],[3,4,5,5,6,7,6,7]]
 *
 *
 * Non e` consentito usare break o continue all'interno di
 * cicli.
 *
 * Non e` consentito modificare in alcun modo il codice al di fuori
 * del metodo "addOdd".
 *
 */

class Node<T>{
    private T elem;
    private Node<T> next;

    public Node(T elem, Node<T> next) {
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
    public String toString() {
        String res = "[";
        res += elem==null?"[]":elem.toString();
        Node<T> p = next;
        while (p != null) {
            res += ","+((p.elem == null?"[]":p.elem.toString()));
            p = p.next;
        }   
        return res += "]";
    }  
}



public class Main4 {

    private static void addOdd(Node<Node<Integer>> ll) {
        Node<Node<Integer>> p = ll;

        while(p!=null){
            Node<Integer> pp = p.getElem();
            while(pp!=null){
                if(pp.getElem()%2 == 0){
                    pp.setNext(new Node<>(pp.getElem()+1,pp.getNext()));
                    pp = pp.getNext();
                }
                pp = pp.getNext();
            }
            p = p.getNext();
        }

    }

    //------ INIZIO CODICE PER IL TESTING ---------------------------------

    public static void main(String[] args) {
        test(crea(), "[]");//[]
        test(crea(crea()), "[[]]");//[[]]
        test(crea(crea(1,2),crea()), "[[1,2,3],[]]");//[[1,2],[]]
        test(crea(crea(),crea(1,2)), "[[],[1,2,3]]");//[[],[1,2]]
        test(crea(crea(1),crea(2)), "[[1],[2,3]]");//[[1],[2]]
        test(crea(crea(1,2),crea(),crea(3,4,5,6,6)), "[[1,2,3],[],[3,4,5,5,6,7,6,7]]");//[[1,2],[],[3,4,5,6,6]]
    }


    private static void test(Node<Node<Integer>> ll, String atteso) {
        String lista = (ll == null?"[]":ll.toString());
        System.out.println("lista    : " + lista);
        addOdd(ll);
        Node<Node<Integer>> ottenuto = ll;
        System.out.println("ottenuto : " + (ottenuto==null?"[]":ll));
        System.out.println("atteso   : " + atteso);
        System.out.println(((ottenuto != null && ottenuto.toString().equals(atteso)) || 
                           (ottenuto == null && atteso.equals("[]"))) ? "=== OK" : "=== ERRORE");
        System.out.println();
    }

    @SafeVarargs
    private static <T> Node<T> crea(T...v) {
        Node<T> n = null;
        for (int i = v.length - 1; i >= 0; i--)
            n = new Node<>(v[i],n);
        return n;
    }
    //------ FINE CODICE PER IL TESTING ----------------------------------
}


