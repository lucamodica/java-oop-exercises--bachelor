import java.util.Arrays;


//Classe calcolatrice, che andrà ad utilizzare la classe stack per memorizzare numeri ed operandi
class Calcolatrice {

    private Stack stack;

    //Costruttore calcolatrice
    public Calcolatrice (){
        stack = new Stack(100);
    }

    /*
    private void stampa() {
        System.out.println("\n Diemsione della pila: " + stack.getSize());
        System.out.println("Contenuto della pila: " + Arrays.toString(stack.getStack()));
    }*/

    //Metodo di esecuzione operazioni
    public int esegui (String operations){

        int numOperazioni = operations.length();
        int pc = 0;

        for (pc=0;pc<numOperazioni;pc++){

            char c = operations.charAt(pc);

            if(c >= '0' && c <= '9'){
                stack.push(c - '0');
            }
            else if (c == '+') {
                int ultimo = stack.pop(); //risultato ultimo calcolo
                int penultimo = stack.pop(); //risultato penultimo calcolo
                stack.push(penultimo + ultimo);
            } 
            else if (c == '*') {
                int ultimo = stack.pop(); //risultato ultimo calcolo
                int penultimo = stack.pop(); //risultato penultimo calcolo
                stack.push(penultimo * ultimo);
            }
            else if (c == '-') {
                int ultimo = stack.pop(); //risultato ultimo calcolo
                int penultimo = stack.pop(); //risultato penultimo calcolo
                stack.push(penultimo - ultimo);
            }
            else if (c == '/') {
                int ultimo = stack.pop(); //risultato ultimo calcolo
                int penultimo = stack.pop(); //risultato penultimo calcolo
                stack.push(penultimo / ultimo);
            }
            else if (c == '%') {
                int ultimo = stack.pop(); //risultato ultimo calcolo
                int penultimo = stack.pop(); //risultato penultimo calcolo
                stack.push(penultimo % ultimo);
            }

        }
        
        return stack.pop();

    }


}


//Classe di testing
public class CalcStackDemo {

    public static void main(String[] args) {

        Calcolatrice C = new Calcolatrice();

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

    }

}