/* Compilare i campi che seguono:
 *
 * NOME        :
 * COGNOME     :
 * MATRICOLA   :
 * N. MACCHINA :
 *
 * Implementare un metodo 'modifica' che aggiunge in fondo a una
 * lista la somma di tutti gli elementi positivi della lista.
 *
 * Ecco alcuni esempi di liste prima e dopo l'esecuzione del metodo:
 *
 * prima :
 * dopo  : 0
 *
 * prima : 5
 * dopo  : 5, 5
 *
 * prima : 5, -3, 1
 * dopo  : 5, -3, 1, 6
 *
 * prima : -1, -1, -6
 * dopo  : -1, -1, -6, 0
 *
 * NON E` CONSENTITO:
 * - usare break o continue o return all'interno di cicli
 * - usare strutture dati ausiliarie (ad esempio array)
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
        int sum = 0;
        Node p = first;
        Node prev = null;
        if(p==null){
            insertFirst(sum);
        }
        else{
            while( p!=null ){
                if(p.getElem()>0){
                    sum+=p.getElem();
                }
                prev = p;
                p = p.getNext();
            }
            prev.setNext(new Node(sum, null));
        }
    }
}

public class Main {
    public static void main(String[] args)
    {
	test(crea(), "0");
	test(crea(5), "5, 5");
	test(crea(5, -3, 1), "5, -3, 1, 6");
	test(crea(-1, -1, -6), "-1, -1, -6, 0");
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

