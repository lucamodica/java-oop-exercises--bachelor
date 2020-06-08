// Tree.Java

// alberi di ricerca su T
public abstract class Tree{

    public abstract boolean empty(); 
    public abstract boolean contains(int x);
    public abstract int max();
    public abstract Tree insert(int x);
    public abstract Tree remove(int x);
    protected abstract String toString(String prefix, String root, String left, String right);
    public String toString() {
        return toString("","___"," "," ");
    }

    //NUOVI METODI
    //Ritorna la somma di tutti gli elementi dell'albero
    public abstract int sum();
    //Ritorna il numero di elementi dell'albero
    public abstract int size();
    //Ritorna il cammino più lungo dalla radice alle sue foglie
    public abstract int depth(); 
    //Ritorna true se viene trovato l'elemento x con cammino lungo al massimo n
    public abstract boolean contains(int x, int n); 
    //Ritorna l'albero con tutti gli elementi dell'originale, minori o uguali a x
    public abstract Tree filter_le(int x);
    //Ritorna tutti gli elementi dell'albero in una lista, in ordine crescente
    public abstract List collect();
    /*
    //Ritorna l'elemento di indice i dell'albero  (indici validi: da 0 a size()-1)
    public abstract int get(int i);
    */
}

