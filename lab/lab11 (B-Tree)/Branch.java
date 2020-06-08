// Branch.java
// Sotto-classe di Tree degli alberi non vuoti:
// elem, gli elementi a sinistra sono minori di elem, quelli a destra sono maggiori

public class Branch extends Tree {
    private int elem; // radice
    private Tree left; // nodi a sinistra: piu' piccoli della radice
    private Tree right; // nodi a destra: piu' grandi della radice

    public Branch(int elem, Tree left, Tree right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public boolean empty() { return false; }
    // Un albero non vuoto... non e' vuoto

    public int max() { return right.empty() ? elem : right.max(); }
    // se la parte destra e' vuota il nodo piu' grande e' la radice,
    // Altrimenti il nodo piu' grande si trova a destra

    // Usa la RICERCA BINARIA
    public boolean contains(int x) {
        if (x == elem) // abbiamo trovato l'elemento
            return true;
        else if (x < elem) // se c'e', x si trova tra i nodi di sinistra
            return left.contains(x);
        else // x > elem
            return right.contains(x); // se c'e', x si trova tra i nodi di destra
    }

    // Inseriamo x preservando l'invariante "albero di ricerca":
    // dunque x va inserito a sinistra se e' piu' piccolo della radice,
    // e a destra se e' piu' grande
    public Tree insert(int x) {
        if (x < elem)
            left = left.insert(x); // aggiungiamo a sinistra
        else if (x > elem)
            right = right.insert(x); // aggiungiamo a destra
        // altrimenti x = elem, x e' gia' presente nell'albero e non lo inseriamo

        return this;
    }

    public Tree remove(int x) {
        if (x == elem) { // trovato elemento da eliminare
            if (left.empty())
                // il sottoalbero sinistro e' vuoto, dunque resta il sottoalbero destro
                return right;
            else if (right.empty())
                // il sottoalbero destro e' vuoto, dunque resta il sottoalbero sinistro
                return left;
            else {
                elem = left.max(); // rimpiazziamo elem con il massimo dell'albero di sinistra
                left = left.remove(elem); //aggiorno il valore di left rimuovendo elem
                return this;
            }
        } else if (x < elem) {
            // se c'e', l'elemento da eliminare e` nel sottoalbero sinistro
            left = left.remove(x); // aggiorno left
            return this;
        } else {
            // se c'e', l'elemento da eliminare e' nel sottoalbero destro
            right = right.remove(x); // aggiorno right
            return this;
        }
    }


    //NUOVI METODI
    //Metodo sum()
    public int sum(){
        return elem + left.sum() + right.sum();
    }
    //Metodo size()
    public int size(){
        return 1 + left.size() + right.size();
    }
    //Metodo depth()
    public int depth(){
        if(left.size() < right.size()){
            return 1 + right.depth();
        }
        return 1 + left.depth();
    }
    //Metodo contains(int x, int n)
    public boolean contains(int x,int n){
        assert n < depth();
        if (x == elem && n >= 0) // abbiamo trovato l'elemento
            return true;
        else if(n<0)
            return false;
        else if (x < elem) // se c'e', x si trova tra i nodi di sinistra
            return left.contains(x,n-1);
        else // x > elem
            return right.contains(x,n-1); // se c'e', x si trova tra i nodi di destra
    }
    //Metodo filter_le(int x)
    public Tree filter_le(int x){
        if(elem <= x){
            return new Branch(elem, left.filter_le(x), right.filter_le(x));
        }
        return left.filter_le(x);
    }
    //Metodo collect()
    public List collect(){
        return new Cons(elem, right.collect());
    }


    // Metodo che gestisce la parte NON pubblica della stampa.
    protected String toString(String prefix, String root, String left, String right) {
        return this.left.toString(prefix + left, "   /", "  ", "  ¦") 
        + prefix + root + "[" + elem + "]\n"
        + this.right.toString(prefix + right, "   \\", "  ¦", "  ");
    }
}


