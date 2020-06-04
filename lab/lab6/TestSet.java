//Clase di testing dei set
public class TestSet {

    public static void main(String[] args){
        
        //Test con set di integer
        Set<Integer> si = new Set<>();
        System.out.println("**Set generico di integer**");
        System.out.println("*Set si*");
        si.add(2);
        si.add(4);
        si.add(6);
        si.print();
        System.out.println();

        System.out.println("Verifica set vuoto: " + si.empty()); //false
        System.out.println("Verifica se contiene 3: " + si.contains(3)); //false
        System.out.println("Verifica se contiene 4: " + si.contains(4)); //true
        System.out.println("Dimesione set: " + si.size()); //stampa 3
        System.out.println("Esito rimozione 5: " + si.remove(5)); //false
        System.out.println("Esito rimozione 4: " + si.remove(4)); //true
        System.out.println("Esito rimozione 2: " + si.remove(2)); //true
        System.out.println("Esito rimozione 6: " + si.remove(6)); //true
        System.out.println("Verifica set vuoto: " + si.empty() + '\n'); //true
        si.add(2);
        si.add(4);
        si.add(6);

        Set<Integer> si1 = new Set<>();
        si1.add(3);
        si1.add(6);
        si1.add(9);
        System.out.println("*Set si1*");
        si1.print();
        System.out.println();

        System.out.println("*Intersezione fra si e si1*");
        Set<Integer> si_intersect = si.intersection(si1); //Intersezione fra si e si1
        si_intersect.print();
        System.out.println();

        System.out.println("*Unione fra si e si1*");
        Set<Integer> si_union = si.union(si1); //Unione fra si e si1
        si_union.print();
        System.out.println("\n\n");



        //Test con set di double
        Set<Double> sd = new Set<>();
        System.out.println("**Set generico di double**");
        System.out.println("*Set sd*");
        sd.add(2.56);
        sd.add(4.25);
        sd.add(6.89);
        sd.print();
        System.out.println();

        System.out.println("Verifica set vuoto: " + sd.empty()); //false
        System.out.println("Verifica se contiene 4.26: " + sd.contains(4.26)); //false
        System.out.println("Verifica se contiene 4.25: " + sd.contains(4.25)); //true
        System.out.println("Dimesione set: " + sd.size()); //stampa 4.25
        System.out.println("Esito rimozione 5.22: " + sd.remove(5.22)); //false
        System.out.println("Esito rimozione 4.25: " + sd.remove(4.25)); //true
        System.out.println("Esito rimozione 2.56: " + sd.remove(2.56)); //true
        System.out.println("Esito rimozione 6.89: " + sd.remove(6.89)); //true
        System.out.println("Verifica set vuoto: " + sd.empty() + '\n'); //true
        sd.add(2.56);
        sd.add(4.25);
        sd.add(6.89);

        Set<Double> sd1 = new Set<>();
        sd1.add(4.25);
        sd1.add(6.89);
        sd1.add(9.17);
        System.out.println("*Set sd1*");
        sd1.print();
        System.out.println();

        System.out.println("*Intersezione fra sd e sd1*");
        Set<Double> sd_intersect = sd.intersection(sd1); //Intersezione fra sd e sd1
        sd_intersect.print();
        System.out.println();

        System.out.println("*Unione fra sd e sd1*");
        Set<Double> sd_union = sd.union(sd1); //Unione fra sd e sd1
        sd_union.print();
        System.out.println("\n\n");

        

        //Test con set di string
        Set<String> ss = new Set<>();
        System.out.println("**Set generico di string**");
        System.out.println("*Set ss*");
        ss.add("Ciao");
        ss.add("come");
        ss.add("stai");
        ss.print();
        System.out.println();

        System.out.println("Verifica set vuoto: " + ss.empty()); //false
        System.out.println("Verifica se contiene 'Luca': " + ss.contains("Luca")); //false
        System.out.println("Verifica se contiene 'come': " + ss.contains("come")); //true
        System.out.println("Dimesione set: " + ss.size()); //stampa come
        System.out.println("Esito rimozione 'Andrea': " + ss.remove("andrea")); //false
        System.out.println("Esito rimozione 'come': " + ss.remove("come")); //true
        System.out.println("Esito rimozione 'Ciao': " + ss.remove("Ciao")); //true
        System.out.println("Esito rimozione 'stai': " + ss.remove("stai")); //true
        System.out.println("Verifica set vuoto: " + ss.empty() + '\n'); //true
        ss.add("Ciao");
        ss.add("come");
        ss.add("stai");

        Set<String> ss1 = new Set<>();
        ss1.add("come");
        ss1.add("Luca");
        ss1.add("sta");
        System.out.println("*Set ss1*");
        ss1.print();
        System.out.println();

        System.out.println("*Intersezione fra ss e ss1*");
        Set<String> ss_intersect = ss.intersection(ss1); //Intersezione fra ss e ss1
        ss_intersect.print();
        System.out.println();

        System.out.println("*Unione fra ss e ss1*");
        Set<String> ss_union = ss.union(ss1); //Unione fra ss e ss1
        ss_union.print();
        System.out.println();



        //Test con set di person
        Set<Person> sp = new Set<>();
        System.out.println("**Set generico di person**");
        System.out.println("*Set sp*");
        sp.add(new Person("Adamo","Severo"));
        sp.add(new Person("Luca","Modica"));
        sp.add(new Person("Marco","Bau"));
        sp.print();
        System.out.println();

        System.out.println("Verifica set vuoto: " + sp.empty()); //false
        System.out.println("Verifica se contiene 'Gabriele Cocco': " + sp.contains(new Person("Gabriele","Cocco"))); //false
        System.out.println("Verifica se contiene 'Luca Modica': " + sp.contains(new Person("Luca","Modica"))); //true
        System.out.println("Dimesione set: " + sp.size()); //stampa come
        System.out.println("Esito rimozione 'Geppetto Sissi': " + sp.remove(new Person("Geppetto","Sissi"))); //false
        System.out.println("Esito rimozione 'Luca Modica': " + sp.remove(new Person("Luca","Modica"))); //true
        System.out.println("Esito rimozione 'Adamo Severo': " + sp.remove(new Person("Adamo","Severo"))); //true
        System.out.println("Esito rimozione 'Marco Bau': " + sp.remove(new Person("Marco","Bau"))); //true
        System.out.println("Verifica set vuoto: " + sp.empty() + '\n'); //true
        sp.add(new Person("Adamo","Severo"));
        sp.add(new Person("Luca","Modica"));
        sp.add(new Person("Marco","Bau"));

        Set<Person> sp1 = new Set<>();
        sp1.add(new Person("Luca","Modica"));
        sp1.add(new Person("Silvia", "mimmi"));
        sp1.add(new Person("Alessia", "Crivi"));
        System.out.println("*Set sp1*");
        sp1.print();
        System.out.println();

        System.out.println("*Intersezione fra sp e sp1*");
        Set<Person> sp_intersect = sp.intersection(sp1); //Intersezione fra sp e sp1
        sp_intersect.print();
        System.out.println();

        System.out.println("*Unione fra sp e sp1*");
        Set<Person> sp_union = sp.union(sp1); //Unione fra sp e sp1
        sp_union.print();
        System.out.println();
        
    }

}