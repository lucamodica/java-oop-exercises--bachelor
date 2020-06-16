// MyList.java
public class MyList {
    private Node first; // Riferimento al primo nodo della lista

    public MyList() {
        this.first = null;
    }

    public void insert(int elem) {
        first = new Node(elem, first);
    }

    public String toString() {
        String res = "";
        for (Node p = first; p != null; p = p.getNext()) {
            res += p.getElem();
            if (p.getNext() != null) res += ", ";
        }
        return res;
    }

    //Il metodo aggiunge ad ogni elemento la somma dei precedenti
    public void modifica(){
        Node prec = null;
        Node p = first;
        int sum = 0;

        while(p != null){
            int elem= p.getElem();
            p.setElem(elem+sum);
            sum += elem;
            prec = first;
            p = p.getNext();
        }
    }

    //il metodo aggiunge in testa alla lista la somma dei nodi
    public void pushSomma(){
        Node p = first;
        int sum = 0;

        while(p != null){
            sum += p.getElem();
            p = p.getNext();
        }
        first = new Node(sum,first);
    }

}

