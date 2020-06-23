
//Classe generica NodeUtil, libreria di metodi per nodi concatenati
public class NodeUtil {

    //1.) Metodo size() (iterativo)
    public static <T> int size(GenericNode<T> p){
        int s = 0;

        if (p != null){
            while(p != null){
                s++;
                p = p.getNext();
            }
        }

        return s;
    }

    //2.) Metodo occurences() (iterativo)
    public static <T> int occurences(GenericNode<T> p, T x){
        int cont = 0;

        if (p != null){
            while(p != null){
                if(p.getElem().equals(x)){
                    cont++;
                }
                p = p.getNext();
            }
        }

        return cont;
    }

    //3.) Metodo included() (iterativo)
    public static <T> boolean included(GenericNode<T> p, GenericNode<T> q){

        //Flag per segnalare lo stesso ordine della lista p nella lista q
        boolean order = false;

        //Verifica iniziale che le 2 liste siano uguali
        if(p.equals(q)){
            order = true;
        }

        //Controllo della presenza di p in q, nello stesso ordine
        while( q != null && !order){
            
            //Se trova l'elemento corrente di p in q, fa avanzare p
            if (q.getElem().equals(p.getElem())){
                p = p.getNext();
                if( p == null ){ 
                    order = true;
                }
            }

            q = q.getNext();

        }

        return order;
    }

    //4.) Metodo reverse() (iterativo)
    public static <T> GenericNode<T> reverseIter(GenericNode<T> p){
        //Lista risultante
        GenericNode<T> res = null;

        //Inserimento progressivo dei nodi del parametro nella lista
        //risultante, in modo da ricavarne la lista inversa
        while( p != null ){
            res = new GenericNode<>(p.getElem(),res);
            p = p.getNext();
        }

        return res;
    }
    //4.) Metodo reverse() (ricorsivo)
    public static <T> GenericNode<T> reverse(GenericNode<T> p){
        GenericNode<T> res = null;

        if( p != null ){
            res = reverseRec(res,p);
        }

        return res;
    }
    public static <T> GenericNode<T> reverseRec(GenericNode<T> res, GenericNode<T> p){
        if( p.getNext() == null ){
            return new GenericNode<T>(p.getElem(),res);
        }
        else{
            //Creazione nodo per l'elemento incotrato della lista p
            GenericNode<T> temp = new GenericNode<>(p.getElem(),res);
            return reverseRec(temp, p.getNext());
        }
    }

    //5.) Metodo prinList() (iterativo)
    public static <T> void printList(GenericNode<T> p){
        if(p != null){
            System.out.print("[ ");
            while(p != null){
                System.out.print(p.getElem());
                if(p.getNext() != null){
                    System.out.print(", ");
                }
                p = p.getNext();
            }
            System.out.print(" ]");
        }
    }

    //6.) Metodo sizeLists() (iterativo)
    public static <T> GenericNode<Integer> sizeListsIter(GenericNode<GenericNode<T>> p){
        //Lista risultante
        GenericNode<Integer> res = null;

        //Ciclo per scorrere ogni lista della lista, calcolando la dimensione
        while(p != null){
            int elem = size(p.getElem());
            res = new GenericNode<>(elem, res);
            p = p.getNext();
        }

        return res;
    }
    //6.) Metodo sizeLists() (ricorsivo)
    public static <T> GenericNode<Integer> sizeLists(GenericNode<GenericNode<T>> p){
        GenericNode<Integer> res = null;

        if( p != null ){
            res = sizeListsRec(res,p);
        }

        return res;
    }
    public static <T> GenericNode<Integer> sizeListsRec(GenericNode<Integer> res, GenericNode<GenericNode<T>> p){
        if( p.getNext() == null ){
            return new GenericNode<Integer>(size(p.getElem()),res);
        }
        else{
            //Creazione nodo per l'elemento incotrato della lista p
            GenericNode<Integer> temp = new GenericNode<>(size(p.getElem()),res);
            return sizeListsRec(temp, p.getNext());
        }
    }

}