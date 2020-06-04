// Rubrica.java
public  class Rubrica { 
    /** Invariante: 
      (i) una volta costruita, una rubrica non contiene lo stesso nome due volte, 
      (ii) (0<=numContatti <= lunghezza vettore contatti) */

    // numero dei contatti attualmente memorizzati nella rubrica
    private int numContatti;        // all'inizio parte a 0
    // array pre-allocato di contatti
    private Contatto[] contatti;    // all'inizio vale null

    public Rubrica(int maxContatti) {
        // costruisce una rubrica con max. num. di contatti  = maxContatti
        numContatti = 0;
        //all'inizio i contatti significativi nella rubrica sono 0
        contatti =  new Contatto[maxContatti];
        /** all'inizio tutti i contatti nella rubrica non sono significativi:
        hanno nome e email uguali a null */
    }
    // La nuova rubrica costruita soddisfa l'invariante

    public  int getNumContatti() {
        return numContatti;
    }
    /** NOTA: non forniamo un metodo get per ottenere il vettore dei contatti:
    conoscendolo, un'altra classe potrebbe leggere e modificare i
    contatti in modo errato (in contraddizione con l’invariante) */

    public void scriviOutput() {
        int i = 0;
        System.out.println("Num. contatti = " + numContatti);
        //Stampiamo i contatti di indice da 0 fino a numContatti-1.
        //Gli altri contatti sono privi di significato
        while(i < numContatti) { 
            contatti[i].scriviOutput();
            ++i;
        }
    }

    //Fuznione di ordinamento della rubrica
    private void ordinaRubrica(){
        int i = 0, j = 0;
        Contatto tmp;   //Variabile di appoggio

        //Ciclo while per confrontare a 2 a 2 le stringhe (bubble sort)
        for(i=numContatti-1;i>0;i--){

            //Secondo ciclo, in modo da assicurarsi l'ordianmento di tutte le stringhe
            for(j=0;j<i;j++){

                //Verifica del valore intero della funzione contatti[j].getNome().compareTo(contatti[j+1].getNome());
                //Se questa è negativa, significa che la stringa contatti[j] è prima di contatti[j+1]
                //Nell'alfabeto.
                String c1 = contatti[j].getNome();  //Primo contatto da confrontare
                String c2 = contatti[j+1].getNome();    //Secondo contatto da confrontare

                if(c1.compareTo(c2) > 0){
                    tmp = contatti[j+1];
                    contatti[j+1] = contatti[j];
                    contatti[j] = tmp;
                }

            }

        }
    }

    /** Il metodo cercaIndice(n) restituisce l'unico indice i di un
    contatto di nome n se c'e', restituisce numContatti se non c'e'. Il
    metodo cercaIndice(n) e' privato per evitare che le altre classi
    modifichino un contatto in contraddizione con l’invariante.
    Esssendo che nel nostro caso la rubrica è ordianta, possiamo ricercare
    il nome dicotomicamente e ridurre lo sforzo computazionale!! */
    //Metodo wrapper
    private int cercaIndice(String n){
        return cercaIndice(n,0,numContatti-1);
    }
    //Metodo ricorsivo
    private int cercaIndice(String n, int l, int r){
        int index = numContatti;  //Indice dell'elemento da cercare
        
        //Ricerca possibile solo se, ovviamente, sono presenti elementi
        if(l <= r && numContatti > 0){
            int m = (l+r)/2; //Calcolo della metà del range
            System.out.println("cmp: " + contatti[m].getNome().compareTo(n));
            //Elemento trovato: assegnazione dell'indice
            if(contatti[m].getNome().compareTo(n) == 0){
                index = m;
            }
            //Elemento minore in ordine alfabetico: ricerca nella metà a sinistra
            else if(contatti[m].getNome().compareTo(n) < 0){
                index = cercaIndice(n, m+1, r);
            }
            //Elemento maggiore in ordine alfabetico: ricerca nella metà a destra
            else{
                index = cercaIndice(n, l, m-1);
            }
        }

        //return del valore trovato (in caso di esito negativo, ritorna la lunghezza dell'array)
        return index;   
    }

    /** usando cercaIndice(n) possiamo stabilire se il nome n e' presente
    nella rubrica */
    public boolean presente(String n) {
        return (cercaIndice(n) < numContatti);
    }

    /** usando cercaIndice(n) possiamo trovare quale e-mail corrisponde a
    un nome presente nella rubrica (restituiamo "" per nome assente) */
    public String cercaEmail(String n) {
        int i= cercaIndice(n);
        //System.out.println(i);
        if (i<numContatti) 
            return contatti[i].getEmail(); 
        else return "";
    }

    /** controlliamo se una rubrica e' piena, cioe' se il numContatti e'
    uguale al numero di elementi che possiamo inserire nel vettore
    contatti */
    public boolean piena() {
        return (numContatti == contatti.length);
    }

    // Aggiungi un nuovo contatto. Se non e' possibile, ritorna false
    public boolean aggiungi(String n, String e) {
        if (presente(n)){
            return false;      // rubrica contiene n: fallimento
        }
            
        if (piena()){
            // rubrica piena: raddoppio della capacità
            int newMax = contatti.length * 2;

            //Creazione nuovo array
            Contatto[] newContatti = new Contatto[newMax];

            //Inserimento dei contatti nella rubrica ampliata e sua assegnazione
            int i = 0;
            while (i < numContatti){
                newContatti[i] = contatti[i];
                i++;
            }
            contatti = newContatti;

            System.out.println("Rubrica raddoppiata in: " + contatti.length);
        }
            

        //aggiungo il nuovo contatto nella prima posizione disponibile
        contatti[numContatti] = new Contatto(n,e);        
        ++numContatti; //aggiorno il numero degli elementi
        System.out.println(n);

        //Ordinamento lessicografico dei contatti
        ordinaRubrica();

        return true; //successo
    }

    // Rimuovi un contatto di nome @n, e riposiziona tutti i
    // contatti che seguono per ricompattare l'array.
    public boolean rimuovi(String n) {
        int i = cercaIndice(n);
        if (i == numContatti) 
            return false; // il contatto manca: fallimento

        //se invece il contatto c'e': diminuiamo di uno i contatti
        --numContatti;
        // spostiamo tutti i contatti indietro di uno sovrascrivendo 
        // il contatto numero i con il successore
        while (i < numContatti) {
            contatti[i] = contatti[i+1]; 
            ++i;
        }

        //Ordinamento lessicografico dei contatti
        ordinaRubrica();

        return true; //successo
    }

    // cerco un contatto di nome n e se lo trovo cambio il nome a n2
    public boolean cambiaNome(String n, String n2) {
        int i = cercaIndice(n), j = cercaIndice(n2);

        //contatto di nome n non trovato oppure di nome n2 trovato:fallimento
        if ((i == numContatti) || (j<numContatti)) 
            return false;

        //Altrimenti cambiamo il nome del contatto i da n a n2
        contatti[i].setNome(n2);

        //Ordinamento lessicografico dei contatti
        ordinaRubrica();

        return true;
    }

    // cerco un contatto di nome n e se lo trovo cambio la email a e2
    public boolean cambiaEmail(String n, String e2) {
        int i = cercaIndice(n);
        //System.out.println(i);
        if (i == numContatti) 
            return false; //contatto di nome n non trovato: fallimento
        //se n e' presente modifichiamo la email
        contatti[i].setEmail(e2);
        return true;
    }
}

