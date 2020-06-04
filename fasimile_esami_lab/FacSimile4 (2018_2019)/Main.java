/* Compilare i campi che seguono:
 *
 * NOME        :
 * COGNOME     :
 * MATRICOLA   :
 * N. MACCHINA :
 *
 * Implementare un metodo 'modifica' che elimina tutti gli elementi
 * negativi di una lista.
 *
 * Ecco alcuni esempi di liste prima e dopo l'esecuzione del metodo:
 *
 * prima :
 * dopo  :
 *
 * prima : 5, -5
 * dopo  : 5
 *
 * prima : -3, 2, -1, 5
 * dopo  : 2, 5
 *
 * prima : -3, -1, -4
 * dopo  :
 *
 * NON E` CONSENTITO:
 * - usare break o continue o return all'interno di cicli
 * - usare strutture dati ausiliarie (ad esempio array)
 * - creare nodi oltre a quelli gia` presenti nella lista
 * - modificare il codice al di fuori dal metodo da implementare
 *
 */

class Node {
    private int elem;
    private Node next;

    public Node(int elem, Node next)
    {
	this.elem = elem;
	this.next = next;
    }

    public int getElem()
    { return elem; }

    public void setElem(int elem)
    { this.elem = elem; }

    public Node getNext()
    { return next; }

    public void setNext(Node next)
    { this.next = next; }
}

class List {
    private Node first;

    public List()
    { first = null; }

    public void insertFirst(int elem)
    { first = new Node(elem, first); }

    public String toString()
    {
	String s = "";
	for (Node p = first; p != null; p = p.getNext()) {
	    if (p != first) s += ", ";
	    s += p.getElem();
	}
	return s;
    }

    public void modifica()
    {
        Node p = first;
        while(p!=null){
            if(p.getElem()<0){
                p.setNext(p.getNext().getNext());
            }
            p = p.getNext();
        }
    }
}

public class Main {
    public static void main(String[] args)
    {
	test(crea(), "");
	test(crea(5, -5), "5");
	test(crea(-3, 2, -1, 5), "2, 5");
	test(crea(-3, -1, -4), "");
    }

    public static void test(List l, String atteso)
    {
	System.out.println("lista    : " + l);
	l.modifica();
	System.out.println("ottenuto : " + l);
	System.out.println("atteso   : " + atteso);
	System.out.println(l.toString().equals(atteso) ? "=== OK" : "=== ERRORE");
	System.out.println();
    }

    public static List crea(Integer...v)
    {
	List l = new List();
	for (int i = v.length - 1; i >= 0; i--)
	    l.insertFirst(v[i]);
	return l;
    }
}
