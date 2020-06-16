public class ContattoDemo {
    // verifica i metodi della classe Contatto
    public static void main(String[] args) {
        Contatto a = new Contatto("a","a@ditta");
        Contatto b = new Contatto("a","b3@ditta");
        System.out.println("Contatto a");
        a.scriviOutput();
        System.out.println("Modifico nome a in b3");
        a.setNome("a");
        a.scriviOutput();
        System.out.println("Modifico email a in b3@ditta");
        a.setEmail("b3@ditta");
        a.scriviOutput();

        System.out.println("Esito confronto fra " + a + " e " + b + ": " + a.compareTo(b));
    }
}
