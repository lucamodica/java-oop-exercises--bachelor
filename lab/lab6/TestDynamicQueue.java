//Test DinamicQueue.java
public class TestDynamicQueue{
    public static void main(String[] args) {

        //**Test per il tipo integer**
        DynamicQueue<Integer> qi = new DynamicQueue<>();
        System.out.println( "**Pila generica Integer qi**" );
        qi.enqueue(17);
        qi.enqueue(42);
        qi.enqueue(4); 
        qi.scriviOutput();

        System.out.println( "qi.empty() = " + qi.empty());
        System.out.println( "qi.contains(4)  = " + qi.contains(4)); //true
        System.out.println( "qi.contains(40) = " + qi.contains(40));//false
        System.out.println("qi.size() = " + qi.size());  // stampa 3
        System.out.println("qi.front()= " + qi.front()); // stampa 17  
        System.out.println(qi.dequeue()); //toglie e stampa 17
        System.out.println(qi.dequeue()); //toglie e stampa 42
        System.out.println(qi.dequeue()); //toglie e stampa 4: coda vuota
        qi.enqueue(17);
        qi.enqueue(42);
        qi.enqueue(4); 

        //Confronto con altre code
        DynamicQueue<Integer> qi1 = new DynamicQueue<>();
        qi1.enqueue(17);
        qi1.enqueue(42);
        qi1.enqueue(4);
        System.out.println("Verifica uguaglianza con la coda qi1: " + qi.equals(qi1));
        DynamicQueue<Integer> qi2 = new DynamicQueue<>();
        qi1.enqueue(17);
        qi1.enqueue(47);
        qi1.enqueue(4);
        System.out.println("Verifica uguaglianza con la coda qi2: " + qi.equals(qi2));

        // gli elementi vengono stampati nello stesso ordine in cui
        // sono stati inseriti, dal momento che la coda e' una
        // struttura FIFO (First-In-First-Out)
        System.out.println( "qi.empty() = " + qi.empty() + "\n\n");



        //**Test per il tipo Double**
        DynamicQueue<Double> qd = new DynamicQueue<>();
        System.out.println( "**Pila generica Double qd**" );
        qd.enqueue(2.65);
        qd.enqueue(7.28);
        qd.enqueue(123.41); 
        qd.scriviOutput();

        System.out.println( "qd.empty() = " + qd.empty());
        System.out.println( "qd.contains(7.00)  = " + qd.contains(7.28)); //true
        System.out.println( "qd.contains(40.1) = " + qd.contains(40.1));//false
        System.out.println("qd.size() = " + qd.size());  // stampa 3
        System.out.println("qd.front()= " + qd.front()); // stampa 2.65  
        System.out.println(qd.dequeue()); //toglie e stampa 2.65
        System.out.println(qd.dequeue()); //toglie e stampa 7.28
        System.out.println(qd.dequeue()); //toglie e stampa 123.41: coda vuota
        qd.enqueue(2.65);
        qd.enqueue(7.28);
        qd.enqueue(123.41); 

        //Confronto con altre code
        DynamicQueue<Double> qd1 = new DynamicQueue<>();
        qd1.enqueue(2.65);
        qd1.enqueue(7.28);
        qd1.enqueue(123.41);
        System.out.println("Verifica uguaglianza con la coda qd1: " + qd.equals(qd1));
        DynamicQueue<Double> qd2 = new DynamicQueue<>();
        qd2.enqueue(3.65);
        qd2.enqueue(8.23);
        qd2.enqueue(123.41);
        System.out.println("Verifica uguaglianza con la coda qd2: " + qd.equals(qd2));

        // gli elementi vengono stampati nello stesso ordine in cui
        // sono stati inseriti, dal momento che la coda e' una
        // struttura FIFO (First-In-First-Out)
        System.out.println( "qd.empty() = " + qd.empty() + "\n\n");



        //**Test per il tipo String**
        DynamicQueue<String> qs = new DynamicQueue<>();
        System.out.println( "**Pila generica String qs**" );
        qs.enqueue("Ciao");
        qs.enqueue("come");
        qs.enqueue("stai"); 
        qs.scriviOutput();

        System.out.println( "qs.empty() = " + qs.empty());
        System.out.println( "qs.contains(come)  = " + qs.contains("come")); //true
        System.out.println( "qs.contains(Luca) = " + qs.contains("Luca"));//false
        System.out.println("qs.size() = " + qs.size());  // stampa 3
        System.out.println("qs.front()= " + qs.front()); // stampa Ciao  
        System.out.println(qs.dequeue()); //toglie e stampa Ciao
        System.out.println(qs.dequeue()); //toglie e stampa come
        System.out.println(qs.dequeue()); //toglie e stampa stai: coda vuota
        qs.enqueue("Ciao");
        qs.enqueue("come");
        qs.enqueue("stai"); 

        //Confronto con altre code
        DynamicQueue<String> qs1 = new DynamicQueue<>();
        qs1.enqueue("Ciao");
        qs1.enqueue("come");
        qs1.enqueue("stai"); 
        System.out.println("Verifica uguaglianza con la coda qs1: " + qs.equals(qs1));
        DynamicQueue<String> qs2 = new DynamicQueue<>();
        qs2.enqueue("Ciao");
        qs2.enqueue("come");
        qs2.enqueue("sta");
        System.out.println("Verifica uguaglianza con la coda qs2: " + qs.equals(qs2));

        // gli elementi vengono stampati nello stesso ordine in cui
        // sono stati inseriti, dal momento che la coda e' una
        // struttura FIFO (First-In-First-Out)
        System.out.println( "qs.empty() = " + qs.empty() + "\n\n");

        

        //**Test per il tipo Person**
        DynamicQueue<Person> qp = new DynamicQueue<>();
        System.out.println( "**Pila generica Person qp**" );
        qp.enqueue(new Person("Luca","Modica"));
        qp.enqueue(new Person("Marco","Tulli"));
        qp.enqueue(new Person("Adamo","Severo"));
        qp.scriviOutput();

        System.out.println( "qp.empty() = " + qp.empty());
        System.out.println( "qp.contains(Adamo Severo)  = " + qp.contains(new Person("Adamo","Severo"))); //true
        System.out.println( "qp.contains(Alberto Balordo) = " + qp.contains(new Person("Alberto","Balordo")));//false
        System.out.println("qp.size() = " + qp.size());  // stampa 3
        System.out.println("qp.front()= " + qp.front()); // stampa Luca Modica  
        System.out.println(qp.dequeue()); //toglie e stampa Luca Modica
        System.out.println(qp.dequeue()); //toglie e stampa Marco Tulli
        System.out.println(qp.dequeue()); //toglie e stampa Adamo Severo: coda vuota
        qp.enqueue(new Person("Luca","Modica"));
        qp.enqueue(new Person("Marco","Tulli"));
        qp.enqueue(new Person("Adamo","Severo"));

        //Confronto con altre code
        DynamicQueue<Person> qp1 = new DynamicQueue<>();
        qp1.enqueue(new Person("Luca","Modica"));
        qp1.enqueue(new Person("Marco","Tulli"));
        qp1.enqueue(new Person("Adamo","Severo"));
        System.out.println("Verifica uguaglianza con la coda qp1: " + qp.equals(qp1));
        DynamicQueue<Person> qp2 = new DynamicQueue<>();
        qp2.enqueue(new Person("Luca","Modica"));
        qp2.enqueue(new Person("Andrea","Pulli"));
        qp2.enqueue(new Person("Adamo","Severo"));
        System.out.println("Verifica uguaglianza con la coda qp2: " + qp.equals(qp2));

        // gli elementi vengono stampati nello stesso ordine in cui
        // sono stati inseriti, dal momento che la coda e' una
        // struttura FIFO (First-In-First-Out)
        System.out.println( "qp.empty() = " + qp.empty() + "\n\n");
        
    }
}

