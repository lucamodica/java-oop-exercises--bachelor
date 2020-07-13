
class Node{
    public int elem;
    public Node next;

    public Node(int elem, Node next){
        this.elem = elem;
        this.next = next;
    }
    
}


public class Es_diff{

    public static Node diff(Node p, Node q){
        if(p == null || q == null){
            return p;
        }
        
        if(p.elem == q.elem){
            return diff(p.next,q);
        }
        else if(p.elem < q.elem){
            return new Node(p.elem,diff(p.next,q));
        }
        return new Node(p.elem,diff(p.next,q.next));
    }

    public static String print(Node l){
        String s = "";
        for (Node p = l; p != null; p = p.next) {
            s += p.elem + "    ";
        }
        return s;
    }

    public static void main(String[] args){

        Node p = new Node(6,null);
        p = new Node(5,p);
        p = new Node(4,p);
        p = new Node(3,p);
        p = new Node(2,p);
        p = new Node(1,p);

        Node q = new Node(6,null);
        q = new Node(4,q);
        q = new Node(2,q);


        System.out.println( print(p) );
        System.out.println( print(q) );
        System.out.println( print(diff(p,q)) );



    }

}