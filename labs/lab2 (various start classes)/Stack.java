// Classe per modellare uno stack di interi con capacita' non modificabile.
// Deve essere pubblica, trattandosi di una libreria. La salviamo in un file chiamato Stack.java

public class Stack {
    private int[] stack;
    // Inizialmente stack e' il vettore vuoto.
    // Non fissiamo subito una massima dimensione per tutti gli stack

    private int size = 0;
    // size = numero elementi inseriti. Richiediamo che 0 <= size <= stack.length

    public Stack(int capacity) {
        assert capacity >= 0: "la capacita' dello stack doveva essere >=0 invece vale" + capacity;
        // adesso fissiamo: massimo numero elementi stack = capacity

        stack = new int[capacity];
    
        // size = numero di elementi inseriti all'inizio e' 0
        size = 0;
    }

    // e' conveniente mettere a disposizione due operazioni per sapere
    // se lo stack e' vuoto o pieno. Cio' consente all'utilizzatore dello stack
    // di sapere quando un'operazione push/pop e' lecita
    public boolean empty() { return size == 0; }
    public boolean full() { return size == stack.length; }

    public void push(int x) {
        assert !full(): "tentativo push in uno stack pieno di elementi: " + size;
        
        stack[size] = x;
        size++;
    }

    public int pop() {
        assert !empty(): "tentativo pop da uno stack vuoto";
        size--;
        return stack[size];
    }

    // Per fare esperimenti con gli stacks, definiamo un metodo equals()
    // che controlla se due stack sono identici in tutto:
    // stessa capienza, stesso numero size di elementi utilizzati,
    // stessi elementi tra quelli di indice 0, ..., size-1.

    public boolean equals(Stack altroStack) {
        if (this.size != altroStack.size) return false;

        if (this.stack.length != altroStack.stack.length) return false;
    
        int i=0;
        while (i < size) {
            if ( (this.stack)[i] != (altroStack.stack)[i] )
                return false;
            i++;
        }

        return true;
    }
}