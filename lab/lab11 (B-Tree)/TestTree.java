// TestTree.java
import java.util.*; // ci serve la classe Random

public class TestTree {

	public static void gay(String gay){
		System.out.println(gay);
		gay("gay");
	}
	
	public static void main(String[] args) {
		Random r = new Random(); // Generatore di numeri casuali
		
		// Creo un albero t che contiene n numeri interi casuali tra 0 e (n-1)
		// (gli interi estratti piu' volte compaiono una volta sola,
		// altri interi non compariranno affatto)
		int n = 8;
		
		Tree t = new Leaf(); // L'albero t nasce vuoto
		System.out.println("\nAlbero vuoto t;\n" + t);
		for (int i = 0; i < n; i++)
			t = t.insert( r.nextInt(n) );
		System.out.println("\nAlbero t (numero di elementi " + t.size() + " );\n" + t);
		System.out.println("La somma di tutti gli elementi di t è: " + t.sum());
		System.out.println("La profondità di t è: " + t.depth());

		// Creo un albero u inserendo sempre elementi piu' grandi, quindi a destra
		Tree u = new Leaf();
		for (int i = 0; i < n; i++)
			u = u.insert(i);
		System.out.println("\nAlbero sbilenco u (numero di elementi " + u.size() + " );\n" + u + '\n');


		//Test ricerca elemento con t.contains(x,n)
		int x = 5;
		System.out.println("Esito della ricerca di x = "+ x + " con profondita' massima 2 : " + t.contains(x,2));
		
		//Test creazione albero con t.filter_le(x)
		x = 4;
		Tree tl = t.filter_le(x);
		System.out.println("\nAlbero filtrato tl (valori minori o uguali di "+ x +");\n" + tl);

		//Test creazione lista con t.collect()
		List l = new Nil();
		l = t.collect();
		System.out.println("Lista contente gli elementi di t, in ordine crescente:\n  " + l);

	}
}