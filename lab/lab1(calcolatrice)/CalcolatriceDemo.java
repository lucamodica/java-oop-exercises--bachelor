import java.util.Arrays;

// Salviamo il tutto nel file CalcolatriceDemo.java
class Calcolatrice { //classe non eseguibile e non pubblica
    // una calcolatrice e' una pila che contiene fino a 100 interi.
    // L'ultimo intero e' il risultato delle operazioni fatte finora
    // e la prossima operazione agisce sugli ultimi due interi a,b
    // e li rimpiazza con a+b (per una addizione) oppure a*b (per una moltiplicazione)

    // stack = pila che contiene fino a 100 interi */
    private int[] stack = new int[100];

    // size = numero di interi introdotti: all'inizio 0
    // le posizioni occupate dell'array hanno indice: 0, 1, ..., size-1
    private int size = 0;

    // push(x): aggiunge un intero x allo stack dopo la parte utilizzata
    // e aumenta di 1 la parte di stack utilizzata (variabile size)
    private void push(int x) {
        stack[size] = x;
        size++;
    }

    // push(x,stack,size): versione con variabili locali
    private void push(int x, int stack[]) {
        stack[size] = x;
    }

    // pop(): restituisce l'ultima intero dello stack
    // e lo "cancella" riducendo di 1 la parte di stack utilizzata (variabize size)
    private int pop() {
        size--;
        return stack[size]; 
    }

    // pop(x,stack,size): versione con variabili locali
    private int pop(int[] stack) {
        return stack[size]; 
    }

    //stampa(): stampa la dimensione corrente della pila
    private void stampa() {
        System.out.println("\n Diemsione della pila: " + size);
        System.out.println("Contenuto della pila: " + Arrays.toString(stack));
    }

    //stampa(): stampa la dimensione corrente della pila (per stack in locale)
    private void stampa(int[] Stack, int Size) {
        System.out.println("\n Diemsione della pila: " + Size);
        System.out.println("Contenuto della pila: " + Arrays.toString(Stack));
    }

    // questo e' un metodo pubblico
    public int esegui(String istruzioni) {
        int numeroIstruzioni = istruzioni.length(); //lunghezza
        int pc = 0; // inizio leggendo la prima istruzione, in posizione 0

        while (pc < numeroIstruzioni) { //eseguo le istruzioni in ordine
            char c = istruzioni.charAt(pc); //c = carattere di posto pc

            if (c >= '0' && c <= '9') { //vero se c e' una cifra
                push(c - '0');  //questa formula mi da' il valore della cifra c
            } 
            else if (c == '+') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo + ultimo);
            } 
            else if (c == '*') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo * ultimo);
            }
            else if (c == '-') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo - ultimo);
            }
            else if (c == '/') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo / ultimo);
            }
            else if (c == '%') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo % ultimo);
            }
            else if (c == '#') {
                stampa();
            }
            else if (c == 's') {
                int ultimo = pop(); //risultato ultimo calcolo
                int res = 0;
                if(ultimo%2 == 0){
                    res = 1;
                }
                push(res);
            }

            pc++; // passiamo alla prossima istruzione
        }

        return pop(); //alla fine restituisco l'ultimo risultato ottenuto
    }

    // questo e' un metodo pubblico (maaaa per stack e size locali)
    public int esegui(String istruzioni, int[] Stack, int Size) {
        int numeroIstruzioni = istruzioni.length(); //lunghezza
        int pc = 0; // inizio leggendo la prima istruzione, in posizione 0

        while (pc < numeroIstruzioni) { //eseguo le istruzioni in ordine
            char c = istruzioni.charAt(pc); //c = carattere di posto pc

            System.out.println(Arrays.toString(Stack));

            if (c >= '0' && c <= '9') { //vero se c e' una cifra
                push(c - '0');  //questa formula mi da' il valore della cifra c
            } 
            else if (c == '+') {
                size--;
                int ultimo = pop(Stack); //risultato ultimo calcolo
                size--;
                int penultimo = pop(Stack); //risultato penultimo calcolo
                push(penultimo + ultimo,Stack);
            } 
            else if (c == '*') {
                size--;
                int ultimo = pop(Stack); //risultato ultimo calcolo
                size--;
                int penultimo = pop(Stack); //risultato penultimo calcolo
                push(penultimo * ultimo,Stack);
                size++;
            }
            else if (c == '-') {
                size--;
                int ultimo = pop(Stack); //risultato ultimo calcolo
                size--;
                int penultimo = pop(Stack); //risultato penultimo calcolo
                push(penultimo - ultimo,Stack);
                size++;
            }
            else if (c == '/') {
                size--;
                int ultimo = pop(Stack); //risultato ultimo calcolo
                size--;
                int penultimo = pop(Stack); //risultato penultimo calcolo
                push(penultimo / ultimo,Stack);
                size++;
            }
            else if (c == '%') {
                size--;
                int ultimo = pop(Stack); //risultato ultimo calcolo
                size--;
                int penultimo = pop(Stack); //risultato penultimo calcolo
                push(penultimo % ultimo,Stack);
                size++;
            }
            else if (c == '#') {
                stampa(Stack,Size);
            }
            else if (c == 's') {
                size--;
                int ultimo = pop(Stack); //risultato ultimo calcolo
                int res = 0;
                if(ultimo%2 == 0){
                    res = 1;
                }
                push(res,Stack);
                size++;
            }

            pc++; // passiamo alla prossima istruzione
        }

        size--;
        return pop(Stack); //alla fine restituisco l'ultimo risultato ottenuto
    }

}

// Un esperimento di uso della classe calcolatrice
// Classe eseguibile pubblica, deve stare in CalcolatriceDemo.java
public class CalcolatriceDemo {
    public static void main(String[] args) {
        Calcolatrice C = new Calcolatrice();

        int[] stack = new int[100];
        int size = 0;
/*
        System.out.println("Eseguo istruzioni 23+ (due piu' tre)");
        System.out.println(C.esegui( "23+" ) + "\n");
        
        System.out.println( "Eseguo istruzioni 23* (due per tre) ");
        System.out.println(C.esegui( "23*" ) + "\n");

        System.out.println("Eseguo istruzioni 23*9+ (due per tre piu' nove) ");
        System.out.println(C.esegui( "23*9+" ) + "\n");

        System.out.println("Eseguo istruzioni 99*9* (nove per nove per nove) ");
        System.out.println(C.esegui( "99*9*" ) + "\n");

        System.out.println("Eseguo istruzioni 99*9*1+ (nove per nove per nove piu' uno) ");
        System.out.println(C.esegui( "99*9*1+" ) + "\n");

        System.out.println("Eseguo (15 + 16) * 17");
        System.out.println(C.esegui( "96+97++98+*" ) + "\n");

        System.out.println("Eseguo il fattoriale di 10");
        System.out.println(C.esegui( "12*3456789*******91+*" ) + "\n");

        System.out.println("Calcolo un numero negativo a piacere");
        System.out.println(C.esegui( "99*9999999999**********" ) + "\n");

        System.out.println("Calcolo 1 - 2");
        System.out.println(C.esegui( "12-" ) + "\n");

        System.out.println("Calcolo 3/2");
        System.out.println(C.esegui( "32/" ) + "\n");

        System.out.println("Calcolo il resto di 5/2");
        System.out.println(C.esegui( "52/" ) + "\n");

        System.out.println("Eseguo il fattoriale di 10 (con stampa dello stato in alcuni punti)");
        System.out.println(C.esegui( "12#*3456789*******91+#*" ) + "\n");

        System.out.println("Calcolo 2n+1 (con un 'n' preso a piacere)");
        int n=7;
        System.out.println(C.esegui( n + "2*1+" ) + "\n");
        
        System.out.println("Calcolo del numero di numeri pari");
        System.out.println(C.esegui( "5s8s+1s9s6s4s++++" ) + "\n");
*/
        //Test con variabili locali, ma con problema nell'aggiornamento di qeuste ultime!!
        System.out.println("Eseguo (15 + 16) * 17 (con variabili locali)");
        System.out.println(C.esegui( "96+97++98+*" ,stack, size) + "\n");

        System.out.println("\n Diemsione della pila: " + size);
        System.out.println("Contenuto della pila: " + Arrays.toString(stack));

    }
}