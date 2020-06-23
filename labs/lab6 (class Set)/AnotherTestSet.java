//Test del remove, per sicurezza
public class AnotherTestSet {

    public static void main(String[] args){

        //Test con set di integer
        Set<Integer> si = new Set<>();
        System.out.println("**Set generico di integer**");
        System.out.println("*Set si*");
        si.add(2);
        si.add(4);
        si.add(7);
        si.add(6);
        si.print();
        System.out.println();

        System.out.println("Verifica se contiene 3: " + si.contains(3)); //false
        System.out.println("Verifica se contiene 4: " + si.contains(4)); //true        
        System.out.println("Dimesione set: " + si.size()); //stampa 3
        System.out.println("Esito rimozione 6: " + si.remove(6)); //false
        si.print();
        System.out.println("Esito rimozione 2: " + si.remove(2)); //true
        si.print();
        System.out.println("Esito rimozione 4: " + si.remove(4)); //true
        si.print();
        System.out.println("Esito rimozione 7: " + si.remove(7)); //true
        si.print();
        System.out.println("Verifica set vuoto: " + si.empty() + '\n'); //true

    }

}