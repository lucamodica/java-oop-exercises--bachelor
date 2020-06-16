class Node<T> {
    public T elem;
    public Node<T> next;
    public Node(T elem, Node<T> next) {
        this.elem = elem;
        this.next = next;
    }
}

public class es1_2{

    //Verifican che q ha almeno tanti elementi quanti p, e che ogni elemento
    //di p sia <= del corrispondente in q
    public static <T extends Comparable<T>> boolean controlla(Node<T> p, Node<T> q) {
        if(q == null && p != null){
            return false;
        }
        else if(p == null){
            return true;
        }
        else if(p.elem.compareTo(q.elem) > 0){
            return false;
        }
        return true && controlla(p.next, q.next);
    }
    
    public static void main(String[] args){

        Node<Integer> p = new Node<>(1, null);
        p = new Node<>(2, p);
        p = new Node<>(0, p);
        p = new Node<>(3, p);


        Node<Integer> q = new Node<>(7, null);
        q = new Node<>(8, q);
        q = new Node<>(7, q);
        q = new Node<>(3, q);
        q = new Node<>(3, q);

        System.out.println("Test: " + controlla(p, q));



    }

}
    