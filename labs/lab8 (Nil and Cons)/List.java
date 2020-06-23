// Un esempio di classe astratta: List
// Liste ordinate di interi per rappresentare insiemi
// INVARIANTE della classe: 
//   in ogni lista gli elementi sono in ordine
// Le sottoclassi Nil, Cons realizzano queste operazioni nei vari casi:
//   Nil: nel caso di una lista con zero elementi (vuota)
//   Cons: nel caso di una lista con almeno un elemento
public abstract class List {
    // Ritorna true se la lista è vuota
    public abstract boolean empty();

    // Ritorna il numero di elementi nella lista.
    public abstract int size();

    // Ritorna true se @x e' contenuto nella lista, false altrimenti.
    public abstract boolean contains(int x);

    // Aggiunge @x alla lista, mantenendo l'ordine.
    // Ritorna una nuova lista opportunamente modificata.
    public abstract List insert(int x);

    // Aggiungi alla lista tutti gli elementi di @l, e ritorna la nuova lista creata.
    public abstract List append(List l);


    //**NUOVI METODI**
    //Somma di tutti gli elementi della lista
    public abstract int sum();

    //Output dell'elemento all'indice i
    public abstract int get(int i);

    //Ritorna una lista con tutti gli elementi della lista incrementati di 1
    public abstract List succ();

    //Sotto-lista con tutti gli elementi <= di x
    public abstract List filter_le(int x);

    //Sotto-lista con tutti gli elementi > di x
    public abstract List filter_gt(int x);

    //Output di una lista che è l'intersezione con un Lista l
    public abstract List intersect(List l);

}
