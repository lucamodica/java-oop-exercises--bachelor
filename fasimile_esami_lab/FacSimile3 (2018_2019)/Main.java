/* Compilare i campi che seguono:
 *
 * NOME        :
 * COGNOME     :
 * MATRICOLA   :
 * N. MACCHINA :
 *
 * Implementare un metodo 'inversioni' che aggiunge in fondo a una
 * lista di numeri il numero di inversioni nella lista, ovvero il
 * numero di elementi immediatamente seguiti da un elemento piu`
 * piccolo.
 *
 * Ecco alcuni esempi di liste prima e dopo l'esecuzione del metodo:
 *
 * prima :
 * dopo  : 0
 *
 * prima : 7
 * dopo  : 7, 0
 *
 * prima : 3, 7, 1
 * dopo  : 3, 7, 1, 1
 *
 * prima : 7, 3, 2, 9, 1
 * dopo  : 7, 3, 2, 9, 1, 3
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

    public void inversioni()
    {

        int inv = 0;
        Node p = first;
        if(p!=null){
            while( p.getNext() != null ){
                if( p.getElem() > p.getNext().getElem() ){
                    inv++;
                }
                p = p.getNext();
            }
            p.setNext(new Node(inv,null));
        }
        else{
            insertFirst(inv);
        }
    
    }
}

public class Main {
    public static void main(String[] args)
    {
	test(crea(), "0");
	test(crea(7), "7, 0");
	test(crea(3, 7, 1), "3, 7, 1, 1");
	test(crea(7, 3, 2, 9, 1), "7, 3, 2, 9, 1, 3");
    }

    public static void test(List l, String atteso)
    {
	System.out.println("lista    : " + l);
	l.inversioni();
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
