//Classe di testing 
public class PilaDinamicaDemo {

    //1. Metodo fromTo(int m, int n)
    public static Node fromTo(int m, int n){
        //Nodo iniziale
        Node t = null;

        if( n >= m ){

            //Creazione nodo iniziale
            t = new Node(n,null);

            //Creazione lista con i numeri compresi nell'intervallo
            for(int i=n-1;i>=m;i--){
                t = new Node(i,t);
            }

        }

        return t;
    }

    //2. Metodo occurences(Node p, int x)
    public static int occurences(Node p, int x){
        //Numero occorrenze
        int occ = 0;

        //Ricerca occorrenze
        while(p != null){
            if( p.getElem() == x ){
                occ++;
            }
            p = p.getNext();
        }

        return occ;
    }

    //3. Metodo included(Node p, Node q)
    public static boolean included(Node p, Node q){

        //Flag per segnalare lo stesso ordine della lista p nella lista q
        boolean order = false;

        //Controllo della presenza di p in q, nello stesso ordine
        while( q != null && !order){
            
            //Se trova l'elemento corrente di p in q, fa avanzare p
            if (q.getElem() == p.getElem()){
                p = p.getNext();
                if( p == null ){ 
                    order = true;
                }
            }

            q = q.getNext();

        }

        return order;
    }

    //4. Metodo reverse(Node p) (iterativo)
    public static Node reverseIter(Node p){
        //Lista risultante
        Node res = null;

        //Inserimento progressivo dei nodi del parametro nella lista
        //risultante, in modo da ricavarne la lista inversa
        while( p != null ){
            res = new Node(p.getElem(),res);
            p = p.getNext();
        }

        return res;
    }
    //4. Metodo reverse(Node p) (ricorsivo)
    public static Node reverseRec(Node p){
        Node res = null;

        if( p != null ){
            res = reverse(res,p);
        }

        return res;
    }
    public static Node reverse(Node res, Node p){
        if( p.getNext() == null ){
            return new Node(p.getElem(),res);
        }
        else{
            //Creazione nodo per l'elemento incotrato della lista p
            Node temp = new Node(p.getElem(),res);
            return reverse(temp, p.getNext());
        }
    }

    //5. Metodo zipSum(Node p, Node q) (iterativo)
    public static Node zipSumIter(Node p, Node q){
        Node s = null;
        while( (p != null) && (q != null) ){
            int sum = p.getElem() + q.getElem();
            s = new Node(sum,s);
            p = p.getNext();
            q = q.getNext();
        }

        return reverseRec(s);    
    }
    //5. Metodo zipSum(Node p, Node q) (ricorsivo)
    public static Node zipSumRec(Node p, Node q){
        Node s = null;
        
        if( (p != null) && (q != null) ){
            s = zipSum(s,p,q);
        }

        return s;    
    }
    public static Node zipSum(Node s, Node p, Node q){
        if( (p.getNext() == null) && (q.getNext() == null) ){
            int sum = p.getElem() + q.getElem();
            s = new Node(sum,s);
            return reverseRec(s);
        }
        else{
            int sum = p.getElem() + q.getElem();
            s = new Node(sum,s);
            return zipSum(s, p.getNext(), q.getNext());
        }
    }


    public static void main(String[] args){

        //Inizializzazione Pila Dinamica
        PilaDinamica p = new PilaDinamica();
        //Aggiunta elementi alla pila
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        p.push(6);
        //Stampa degli elementi, trasferendoli prima in un array
        int[] arr = p.toArray();
        System.out.println("Elementi della pila: ");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + "   ");
        }
        System.out.println('\n');


        //1.: **Creazione e stampa di una lista entro un certo range di valori**
        //Ranges
        int sx = 5;
        int dx = 10;
        //Lista
        Node list1 = fromTo(sx, dx);
        //Stampa lista
        System.out.println("Stampa elenco dei numeri da " + sx + " a " + dx + ":");
        System.out.print("[");
        while( list1 != null ){
            System.out.print(list1.getElem());
            if(list1.getNext() != null){
                System.out.print(", ");
            }
            list1 = list1.getNext();
        }
        System.out.println("]\n");

        
        //2.: **Ricerca numero di occorrenze all'interno di una lista**
        //Lista
        Node list2 = new Node(2, null);
        //Caricamento lista
        list2 = new Node(4, list2);
        list2 = new Node(2, list2);
        list2 = new Node(2, list2);
        list2 = new Node(8, list2);
        list2 = new Node(4, list2);
        //Ricerca occorrenze nella lista
        int x = 2;
        System.out.println("Occorrenze del numero " + x + " nella list2: " + occurences(list2, x) + "\n");


        //3.: **Confronto fra 2 liste per verificare se la prima compare stesso ordine nella seconda**
        //Prima lista
        Node listp = new Node(3,null);
        listp = new Node(2,listp);
        listp = new Node(1,listp);
        //Seconda lista
        Node listq = new Node(4,null);
        listq = new Node(2, listq);
        listq = new Node(0, listq);
        listq = new Node(3, listq);
        listq = new Node(2, listq);
        listq = new Node(1, listq);
        listq = new Node(0, listq);
        //Controllo per verificare se p compare nello stesso ordine in q
        System.out.println("Esito verifica della comparsa di listp nello stesso ordine in listq: " + included(listp, listq) + '\n');


        //4.: **Creazione di una lista inversa data una lista in input**
        Node list4 = new Node(2,null);
        list4 = new Node(4,list4);
        list4 = new Node(6,list4);
        list4 = new Node(8,list4);
        //Crezione lista inversa
        //Node list_reverse = reverseIter(list4);
        Node list_reverse = reverseRec(list4);
        //Stampa lista originale
        System.out.print("Stampa lista non invertita: ");
        System.out.print("[");
        while( list4 != null ){
            System.out.print(list4.getElem());
            if(list4.getNext() != null){
                System.out.print(", ");
            }
            list4 = list4.getNext();
        }
        System.out.println("]");
        //Stampa lista inversa
        System.out.print("Stampa lista invertita:");
        System.out.print("[");
        while( list_reverse != null ){
            System.out.print(list_reverse.getElem());
            if(list_reverse.getNext() != null){
                System.out.print(", ");
            }
            list_reverse = list_reverse.getNext();
        }
        System.out.println("]\n");


        //5.: **somma degli elementi di 2 liste (che si assume siano di lunghezza uguale)**
        //Prima lista
        Node listA = new Node(3,null);
        listA = new Node(6,listA);
        listA = new Node(9,listA);
        //Seconda lista
        Node listB = new Node(2,null);
        listB = new Node(4,listB);
        listB = new Node(6,listB);
        //Somma
        //Node sum = zipSumIter(listA, listB);
        Node sum = zipSumRec(listA, listB);
        //Stampa dei risultati
        System.out.print("Prima lista da sommare:");
        System.out.print("[");
        while( listA != null ){
            System.out.print(listA.getElem());
            if(listA.getNext() != null){
                System.out.print(", ");
            }
            listA = listA.getNext();
        }
        System.out.println("]");
        System.out.print("Seconda lista da sommare:");
        System.out.print("[");
        while( listB != null ){
            System.out.print(listB.getElem());
            if(listB.getNext() != null){
                System.out.print(", ");
            }
            listB = listB.getNext();
        }
        System.out.println("]");
        System.out.print("Somma:");
        System.out.print("[");
        while( sum != null ){
            System.out.print(sum.getElem());
            if(sum.getNext() != null){
                System.out.print(", ");
            }
            sum = sum.getNext();
        }
        System.out.println("]");

    }
}