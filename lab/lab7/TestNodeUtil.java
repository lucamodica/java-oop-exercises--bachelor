//Classe di testing per i metodi della libreria NodeUtil
public class TestNodeUtil {

    public static void main(String[] args){

        //***Test per Nodi integer***
        //Creazione prima lista
        GenericNode<Integer> ni1 = new GenericNode<>(1, null);
        ni1 = new GenericNode<>(2, ni1);
        ni1 = new GenericNode<>(3, ni1);
        ni1 = new GenericNode<>(4, ni1);
        ni1 = new GenericNode<>(5, ni1);
        //Seconda lista
        GenericNode<Integer> ni2 = new GenericNode<>(1, null);
        ni2 = new GenericNode<>(1, ni2);
        ni2 = new GenericNode<>(2, ni2);
        ni2 = new GenericNode<>(5, ni2);
        ni2 = new GenericNode<>(3, ni2);
        ni2 = new GenericNode<>(4, ni2);
        //Creazione terza lista
        GenericNode<Integer> ni3 = new GenericNode<>(1, null);
        ni3 = new GenericNode<>(2, ni3);
        ni3 = new GenericNode<>(3, ni3);
        ni3 = new GenericNode<>(4, ni3);
        ni3 = new GenericNode<>(5, ni3);
        //Creazione quarta lista
        GenericNode<Integer> ni4 = null;
        //Lista di liste ( per il punto 6.) )
        GenericNode<GenericNode<Integer>> lists_i = new GenericNode<>(ni1, null);
        lists_i = new GenericNode<>(ni2, lists_i);
        lists_i = new GenericNode<>(ni3, lists_i);
        lists_i = new GenericNode<>(ni4, lists_i);

        System.out.println("***Test con liste generiche di interi***");
        System.out.println("1.) size(ni1) = " + NodeUtil.size(ni1));
        System.out.println("2.) occurences(ni1,3) = " + NodeUtil.occurences(ni1,3));
        System.out.println("3.) included(ni1,ni2) = " + NodeUtil.included(ni1,ni2));
        System.out.println("3.) included(ni1,ni3) = " + NodeUtil.included(ni1,ni3));
        System.out.print("4.) reverse(ni1) = ");
        NodeUtil.printList(NodeUtil.reverse(ni1));
        System.out.println();
        System.out.print("5.) printList(ni2) = ");
        NodeUtil.printList(ni2);
        System.out.println();
        System.out.print("6.) sizeLists(lists_i) = ");
        NodeUtil.printList(NodeUtil.sizeLists(lists_i));
        System.out.println("\n\n");



        //***Test per Nodi double***
        //Creazione prima lista
        GenericNode<Double> nd1 = new GenericNode<>(2.3, null);
        nd1 = new GenericNode<>(3.58, nd1);
        nd1 = new GenericNode<>(4.72, nd1);
        nd1 = new GenericNode<>(15.26, nd1);
        nd1 = new GenericNode<>(7.10, nd1);
        //Seconda lista
        GenericNode<Double> nd2 = new GenericNode<>(2.3, null);
        nd2 = new GenericNode<>(2.3, nd2);
        nd2 = new GenericNode<>(3.58, nd2);
        nd2 = new GenericNode<>(7.10, nd2);
        nd2 = new GenericNode<>(4.72, nd2);
        nd2 = new GenericNode<>(15.26, nd2);
        //Creazione terza lista
        GenericNode<Double> nd3 = new GenericNode<>(2.3, null);
        nd3 = new GenericNode<>(3.58, nd3);
        nd3 = new GenericNode<>(4.72, nd3);
        nd3 = new GenericNode<>(15.26, nd3);
        nd3 = new GenericNode<>(7.10, nd3);
        //Creazione quarta lista
        GenericNode<Double> nd4 = null;
        //Lista di liste ( per il punto 6.) )
        GenericNode<GenericNode<Double>> lists_d = new GenericNode<>(nd1, null);
        lists_d = new GenericNode<>(nd2, lists_d);
        lists_d = new GenericNode<>(nd3, lists_d);
        lists_d = new GenericNode<>(nd4, lists_d);

        System.out.println("***Test con liste generiche di double***");
        System.out.println("1.) size(nd1) = " + NodeUtil.size(nd1));
        System.out.println("2.) occurences(nd1,4.72) = " + NodeUtil.occurences(nd1,4.72));
        System.out.println("3.) included(nd1,nd2) = " + NodeUtil.included(nd1,nd2));
        System.out.println("3.) included(nd1,nd3) = " + NodeUtil.included(nd1,nd3));
        System.out.print("4.) reverse(nd1) = ");
        NodeUtil.printList(NodeUtil.reverse(nd1));
        System.out.println();
        System.out.print("5.) printList(nd2) = ");
        NodeUtil.printList(nd2);
        System.out.println();
        System.out.print("6.) sizeLists(lists_d) = ");
        NodeUtil.printList(NodeUtil.sizeLists(lists_d));
        System.out.println("\n\n");



        //***Test per Nodi string***
        //Creazione prima lista
        GenericNode<String> ns1 = new GenericNode<>("Ciao", null);
        ns1 = new GenericNode<>("come", ns1);
        ns1 = new GenericNode<>("stai", ns1);
        ns1 = new GenericNode<>("tutto", ns1);
        ns1 = new GenericNode<>("bene", ns1);
        //Seconda lista
        GenericNode<String> ns2 = new GenericNode<>("Ciao", null);
        ns2 = new GenericNode<>("Ciao", ns2);
        ns2 = new GenericNode<>("come", ns2);
        ns2 = new GenericNode<>("bene", ns2);
        ns2 = new GenericNode<>("stai", ns2);
        ns2 = new GenericNode<>("tutto", ns2);
        //Creazione terza lista
        GenericNode<String> ns3 = new GenericNode<>("Ciao", null);
        ns3 = new GenericNode<>("come", ns3);
        ns3 = new GenericNode<>("stai", ns3);
        ns3 = new GenericNode<>("tutto", ns3);
        ns3 = new GenericNode<>("bene", ns3);
        //Creazione quarta lista
        GenericNode<String> ns4 = null;
        //Lista di liste ( per il punto 6.) )
        GenericNode<GenericNode<String>> lists_s = new GenericNode<>(ns1, null);
        lists_s = new GenericNode<>(ns2, lists_s);
        lists_s = new GenericNode<>(ns3, lists_s);
        lists_s = new GenericNode<>(ns4, lists_s);

        System.out.println("***Test con liste generiche di string***");
        System.out.println("1.) size(ns1) = " + NodeUtil.size(ns1));
        System.out.println("2.) occurences(ns1,'stai') = " + NodeUtil.occurences(ns1,"stai"));
        System.out.println("3.) included(ns1,ns2) = " + NodeUtil.included(ns1,ns2));
        System.out.println("3.) included(ns1,ns3) = " + NodeUtil.included(ns1,ns3));
        System.out.print("4.) reverse(ns1) = ");
        NodeUtil.printList(NodeUtil.reverse(ns1));
        System.out.println();
        System.out.print("5.) printList(ns2) = ");  
        NodeUtil.printList(ns2);
        System.out.println();
        System.out.print("6.) sizeLists(lists_i) = ");
        NodeUtil.printList(NodeUtil.sizeLists(lists_i));
        System.out.println("\n\n");


        
        //***Test per Nodi Person***
        //Creazione prima lista
        GenericNode<Person> np1 = new GenericNode<>(new Person("Luca","Modica"), null);
        np1 = new GenericNode<>(new Person("Marco","Tulli"), np1);
        np1 = new GenericNode<>(new Person("Adamo","Severo"), np1);
        np1 = new GenericNode<>(new Person("Andrea","Pulli"), np1);
        np1 = new GenericNode<>(new Person("Alberto","Balordo"), np1);
        //Seconda lista
        GenericNode<Person> np2 = new GenericNode<>(new Person("Luca","Modica"), null);
        np2 = new GenericNode<>(new Person("Luca","Modica"), np2);
        np2 = new GenericNode<>(new Person("Marco","Tulli"), np2);
        np2 = new GenericNode<>(new Person("Alberto","Balordo"), np2);
        np2 = new GenericNode<>(new Person("Adamo","Severo"), np2);
        np2 = new GenericNode<>(new Person("Andrea","Pulli"), np2);
        //Creazione terza lista
        GenericNode<Person> np3 = new GenericNode<>(new Person("Luca","Modica"), null);
        np3 = new GenericNode<>(new Person("Marco","Tulli"), np3);
        np3 = new GenericNode<>(new Person("Adamo","Severo"), np3);
        np3 = new GenericNode<>(new Person("Andrea","Pulli"), np3);
        np3 = new GenericNode<>(new Person("Alberto","Balordo"), np3);
        //Creazione quarta lista
        GenericNode<Person> np4 = null;
        //Lista di liste ( per il punto 6.) )
        GenericNode<GenericNode<Person>> lists_p = new GenericNode<>(np1, null);
        lists_p = new GenericNode<>(np2, lists_p);
        lists_p = new GenericNode<>(np3, lists_p);
        lists_p = new GenericNode<>(np4, lists_p);

        System.out.println("***Test con liste generiche di Person***");
        System.out.println("1.) size(np1) = " + NodeUtil.size(np1));
        System.out.println("2.) occurences(np1,new Person('Adamo','Severo')) = " + NodeUtil.occurences(np1,new Person("Adamo","Severo")));
        System.out.println("3.) included(np1,np2) = " + NodeUtil.included(np1,np2));
        System.out.println("3.) included(np1,np3) = " + NodeUtil.included(np1,np3));
        System.out.print("4.) reverse(np1) = ");
        NodeUtil.printList(NodeUtil.reverse(np1));
        System.out.println();
        System.out.print("5.) printList(np2) = ");
        NodeUtil.printList(np2);
        System.out.println();
        System.out.print("6.) sizeLists(lists_p) = ");
        NodeUtil.printList(NodeUtil.sizeLists(lists_p));
        System.out.println("\n\n");


    }

}