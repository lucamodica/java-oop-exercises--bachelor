
public class TestLists {
    
    public static void main(String[] args){

        List l1 = new Nil();
        List l2 = new Nil();
        List l3 = new Nil();
        List l4 = new Nil();

        System.out.println("Lista l1: " + l1);

        try {

            l2 = new Cons(3, l2);
            l2 = new Cons(2, l2);
            System.out.println("Lista l2: " + l2);

            l3 = new Cons(3, l3);
            l3 = new Cons(2, l3);
            System.out.println("Lista l3: " + l3);

            l4 = new Cons(1, l4);
            l4 = new Cons(2, l4);
            l4 = new Cons(3, l4);
            System.out.println("Lista l4: " + l4);

            System.out.println("\nPROVE DI INSERIMENTO");
            System.out.println("Prova in l1: " + l1.insert(0, 5));
            System.out.println("Prova in l2: " + l2.insert(1, -1));
            System.out.println("Prova in l3: " + l3.insert(0, -1));
            System.out.println("Prova in l4: " + l4.insert(10, 9));
            
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

    }

}