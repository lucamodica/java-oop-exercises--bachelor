public class TestList {

    public static void main(String[] args) {
        
        MyList list0 = new MyList();

        MyList list1 = new MyList();
        list1.insert(5);
        
        MyList list2 = new MyList();
        list2.insert(1);
        list2.insert(3);
        list2.insert(5);

        MyList list3 = new MyList();
        list3.insert(4);
        list3.insert(0);
        list3.insert(1);
        list3.insert(-1);

        System.out.println("\nLISTE PRIMA DELLA MODIFICA");
        System.out.println("List0: " + list0);
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);

        list0.modifica();
        list1.modifica();
        list2.modifica();
        list3.modifica();

        System.out.println("\nLISTE DOPO DELLA MODIFICA");
        System.out.println("List0: " + list0);
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);

        list0.pushSomma();
        list1.pushSomma();
        list2.pushSomma();
        list3.pushSomma();

        System.out.println("\nLISTE DOPO pushSomma()");
        System.out.println("List0: " + list0);
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);

    }

}