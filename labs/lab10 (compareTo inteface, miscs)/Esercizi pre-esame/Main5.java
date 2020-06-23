/* 
 * Implementare un metodo removeLessThan che accetta in input
 * una lista di liste di numeri interi, e, in ogni lista interna, elimina
 * tutti gli elementi minori di un certo x specificato.
 *
 * Si assuma che:
 * 1) la lista vuota sia rappresentata dal valore null;
 * 2) gli elementi dei nodi delle liste interne non siano mai null.
 *
 * Seguono alcuni esempi di risultati attesi da removeLessThan(3).
 *
 * lista  : []
 * atteso : []
 *
 * lista  : [[]]
 * atteso : [[]]
 *
 * lista  : [[1,2],[]]
 * atteso : [[],[]]
 *
 * lista  : [[],[1,2]]
 * atteso : [[],[]]
 *
 * lista  : [[1,2,2,3],[2,3,2]]
 * atteso : [[3],[3]]
 *
 * lista  : [[4],[5]]
 * atteso : [[4],[5]]
 *
 * lista  : [[1,2],[],[2,3,4,5,6,6]]
 * atteso : [[],[],[3,4,5,6,6]]
 *
 *
 * Non e` consentito usare break o continue all'interno di
 * cicli.
 *
 * Non e` consentito modificare in alcun modo il codice al di fuori
 * del metodo "removeLessThan".
 *
 */

import java.util.*;

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



public class Main5 {
    private static void removeLessThan(Node<Node<Integer>> ll, int x) {

        //Verifica che il pointer della lista di liste sia null
        if(ll==null){return;}


        //Verfica che la sottolista sia null 
        if(ll.getElem()==null){
            removeLessThan(ll.getNext(), x);
            return;
        }

        //Verifica della condizione per tutti gli elementi della sottolista, eccetto per la testa
        Node<Integer> prev = ll.getElem();
        Node<Integer> k = prev.getNext();
        while(k!=null){
            if(k.getElem().compareTo(x) < 0){
                prev.setNext(k.getNext());
                k = k.getNext();
            }
            else{
                prev = k;
                k = k.getNext();
            }
            
        }

        //Verifica della condizione per l'elemento in testa
        if(ll.getElem().getElem().compareTo(x) < 0){
            ll.setElem(ll.getElem().getNext());
        }

        removeLessThan(ll.getNext(), x);
    }   

    //------ INIZIO CODICE PER IL TESTING ---------------------------------

    public static void main(String[] args) {
        test(crea(), "[]");//[]
        test(crea(crea()), "[[]]");//[[]]
        test(crea(crea(1,2),crea()), "[[],[]]");//[[1,2],[]]
        test(crea(crea(),crea(1,2)), "[[],[]]");//[[],[1,2]]
        test(crea(crea(1,2,2,3),crea(2,3,2)), "[[3],[3]]");//[[1,2,2,3],[2,3,2]]
        test(crea(crea(4),crea(5)), "[[4],[5]]");//[[4],[5]]
        test(crea(crea(1,2),crea(),crea(2,3,4,5,6,6)), "[[],[],[3,4,5,6,6]]");//[[1,2],[],[2,3,4,5,6,6]]
    }
    private static void test(Node<Node<Integer>> ll, String atteso) {
        String lista = (ll == null?"[]":ll.toString());
        System.out.println("lista    : " + lista);
        removeLessThan(ll, 3);
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





