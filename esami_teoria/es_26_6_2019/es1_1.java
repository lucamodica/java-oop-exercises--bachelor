class Node<T> {
    public T elem;
    public Node<T> next;
    public Node(T elem, Node<T> next) {
        this.elem = elem;
        this.next = next;
    }
}

public class es1_1{

    //Il metodo controlla se l'ultimi elemento di p è <= del primo di q 
    public static <T extends Comparable<T>> boolean controlla(Node<T> p, Node<T> q) {
        if(p == null || q == null){
            return true;
        }
        else if(p.next == null){
            if(p.elem.compareTo(q.elem) <= 0){
                return true;
            }
            return false;
        }
        return true && controlla(p.next, q);
    }
    
    public static void main(String[] args){

        Node<Integer> p = new Node<>(5, null);
        p = new Node<>(7, p);


        Node<Integer> q = new Node<>(7, null);
        q = new Node<>(8, q);
        q = new Node<>(5, q);

        System.out.println("Test: " + controlla(p, q));



    }

}
    